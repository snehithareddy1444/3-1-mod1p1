package com.example.mod1p1.model

data class ChatRequest(
    val contents: List<RequestContent>
)

data class RequestContent(
    val parts: List<RequestPart>
)

data class RequestPart(
    val text: String
)
