package com.example.android.limbuslist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sinners(
    val name: String,
    val quote: String,
    val photoWide: Int
) : Parcelable