package com.singularitycoder.mycloud

data class Host(
    var name: String = "",
    var mobileNumber: String = "",
    var dateStarted: Long = 0,
    var imagePath: String = "",
    var rating: Float = 0f,
    var ratingCount: Int = 0,
    var storageSpace: Double = 0.0,
)