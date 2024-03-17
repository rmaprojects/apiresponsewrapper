package com.rmaprojects.apiresponsewrappersample

import androidx.lifecycle.ViewModel
import com.rmaprojects.apiresponsewrappersample.data.Repository

class MainViewModel(
    repository: Repository
): ViewModel() {

    val data = repository.getData()
}