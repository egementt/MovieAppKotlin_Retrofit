package com.tokgozdev.moviekotlin.model

import java.io.Serializable

data class Movie(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)