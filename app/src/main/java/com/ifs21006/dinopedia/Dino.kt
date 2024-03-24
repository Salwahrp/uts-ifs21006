package com.ifs21006.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.ProtocolFamily

@Parcelize
data class Dino(
    var photo: Int,
    var name: String = "",
    var deskripsi: String = "",
) : Parcelable
