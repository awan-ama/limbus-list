package com.example.android.limbuslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.limbuslist.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sinnerName = arguments?.getString("sinnerName")
        val sinnerQuote = arguments?.getString("sinnerQuote")
        val sinnerPhoto = arguments?.getInt("sinnerPhoto")

        binding.sinnersName.text = sinnerName
        binding.sinnersQuote.text = sinnerQuote
        sinnerPhoto?.let { binding.sinnersPhoto.setImageResource(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
