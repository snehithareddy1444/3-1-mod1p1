package com.example.mod1p1.network

import com.example.mod1p1.model.ChatRequest
import com.example.mod1p1.model.ChatResponse
import com.example.mod1p1.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST(END_POINT)
    suspend fun getAIResponse(
        @Header("x-goog-api-key") apiKey: String,
        @Body request: ChatRequest
    ): Response<ChatResponse>
}