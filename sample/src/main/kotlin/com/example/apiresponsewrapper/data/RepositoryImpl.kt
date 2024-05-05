package com.example.apiresponsewrapper.data

import com.rmaprojects.apirequeststate.ResponseState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl: Repository {
    override fun getData(): Flow<ResponseState<List<String>>> {
        return flow {
            emit(ResponseState.Loading)
            delay(4000)
            emit(ResponseState.Success(listOf("Mamang", "Sumamang", "Sumanggimang")))
        }
    }
}