package com.example.mod1p1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mod1p1.repository.AIRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = AIRepository()

    val response = MutableLiveData<String>()
    val loading = MutableLiveData(false)

    fun askAI(prompt: String) {
        viewModelScope.launch {
            loading.value = true

            try {
                response.value = repository.getAIResponse(prompt)
            } catch (e: Exception) {
                e.printStackTrace()
                response.value = "Error: ${e.message ?: "Unable to connect to Gemini"}"
            } finally {
                loading.value = false
            }
        }
    }
}
