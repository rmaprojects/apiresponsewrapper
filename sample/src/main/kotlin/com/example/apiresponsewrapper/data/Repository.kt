package com.example.apiresponsewrapper.data

import com.rmaprojects.apirequeststate.ResponseState
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getData(): Flow<ResponseState<List<String>>>
}