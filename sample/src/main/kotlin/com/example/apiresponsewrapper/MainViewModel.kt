package com.example.apiresponsewrapper

import androidx.lifecycle.ViewModel
import com.example.apiresponsewrapper.data.Repository

class MainViewModel(
    repository: Repository
): ViewModel() {

    val data = repository.getData()
}