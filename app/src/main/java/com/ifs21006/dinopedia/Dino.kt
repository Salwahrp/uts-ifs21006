package com.ifs21006.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dino(
    var name: String,
    var photo: Int,
    var family: String,
    var deskripsi: String,
    var periode: String,
    var karakteristik: String,
    var habitat: String,
    var perilaku: String
) : Parcelable
