package com.utsman.androidmvvm.model

import com.google.gson.annotations.SerializedName

data class ReqresResponses(
    @SerializedName("data")
    val data: MutableList<Data>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)