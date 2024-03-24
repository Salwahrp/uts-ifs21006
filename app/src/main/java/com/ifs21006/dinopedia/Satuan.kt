package com.ifs21006.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Satuan(
    var name: String,
    var photo: Int,
    var family: String,
    var deskripsi: String,
    var habitat: String,
    var periode: String,
    var karakteristik: String,
    var perilaku: String
) : Parcelable