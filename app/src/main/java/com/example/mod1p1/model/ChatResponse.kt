package com.example.mod1p1.model

data class ChatResponse(
    val candidates: List<Candidate>?
) {
    val response: String
        get() = candidates
            ?.firstOrNull()
            ?.content
            ?.parts
            ?.firstOrNull()
            ?.text
            ?: "No response received"
}

data class Candidate(
    val content: Content?
)

data class Content(
    val parts: List<Part>?
)

data class Part(
    val text: String?
)
