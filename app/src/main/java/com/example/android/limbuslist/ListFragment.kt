package com.example.android.limbuslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.limbuslist.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var sinnersList: RecyclerView
    private val list = ArrayList<Sinners>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sinnersList = binding.sinnersList
        sinnersList.setHasFixedSize(true)
        list.clear()
        list.addAll(getListSinners())

        showRecyclerList()
    }

    private fun getListSinners(): ArrayList<Sinners> {
        val dataName = resources.getStringArray(R.array.sinners_name)
        val dataQuote = resources.getStringArray(R.array.sinners_quote)
        val dataPhoto = resources.obtainTypedArray(R.array.sinners_photo)
        val listSinners = ArrayList<Sinners>()
        for (i in dataName.indices) {
            val sinners = Sinners(dataName[i], dataQuote[i], dataPhoto.getResourceId(i, -1))
            listSinners.add(sinners)
        }
        return listSinners
    }

    private fun showRecyclerList() {
        val navController = findNavController()
        sinnersList.layoutManager = LinearLayoutManager(requireContext())
        val listSinnersAdapter = ListSinnersAdapter(list, navController)
        sinnersList.adapter = listSinnersAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
