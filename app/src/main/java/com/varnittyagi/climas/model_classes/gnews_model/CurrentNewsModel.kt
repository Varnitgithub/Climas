package com.varnittyagi.climas.model_classes.gnews_model

data class CurrentNewsModel(
    val news: List<New>,
    val page: Int,
    val status: String
)