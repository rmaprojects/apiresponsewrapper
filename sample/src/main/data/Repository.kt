package com.rmaprojects.apiresponsewrappersample.data

import com.rmaprojects.apirequeststate.RequestState
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getData(): Flow<RequestState<List<String>>>
}