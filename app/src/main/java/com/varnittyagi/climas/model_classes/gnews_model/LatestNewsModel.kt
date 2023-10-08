package com.varnittyagi.climas.model_classes.gnews_model

data class LatestNewsModel(
    val news: List<NewX>,
    val page: Int,
    val status: String
)