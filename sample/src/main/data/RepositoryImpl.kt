package com.rmaprojects.apiresponsewrappersample.data

import com.rmaprojects.apirequeststate.RequestState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl: Repository {
    override fun getData(): Flow<RequestState<List<String>>> {
        return flow {
            emit(RequestState.Loading)
            delay(4000)
            emit(RequestState.Success(listOf("Mamang", "Sumamang", "Sumanggimang")))
        }
    }
}