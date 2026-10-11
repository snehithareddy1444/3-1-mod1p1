package com.example.mod1p1.repository

import com.example.mod1p1.model.ChatRequest
import com.example.mod1p1.model.RequestContent
import com.example.mod1p1.model.RequestPart
import com.example.mod1p1.network.ApiClient
import com.example.mod1p1.utils.Constants

class AIRepository {

    suspend fun getAIResponse(prompt: String): String {
        val request = ChatRequest(
            contents = listOf(
                RequestContent(
                    parts = listOf(
                        RequestPart(text = prompt)
                    )
                )
            )
        )

        val response = ApiClient.apiService.getAIResponse(
            Constants.API_KEY,
            request
        )

        if (!response.isSuccessful) {
            throw Exception(
                "Gemini API error: HTTP ${response.code()} - " +
                        response.errorBody()?.string().orEmpty()
            )
        }

        return response.body()?.response
            ?: "No response received from Gemini"
    }
}