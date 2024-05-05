package com.example.apiresponsewrapper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apiresponsewrapper.ui.ApiResponseWrapperSampleTheme
import com.rmaprojects.apirequeststate.ResponseState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val viewModel = viewModel<MainViewModel>()

            val data = viewModel.data.collectAsState(initial = ResponseState.Idle)
            ApiResponseWrapperSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    data.value.DisplayResult(
                        onLoading = {
                            //TODO Put your UI Here
                        },
                        onSuccess = {
                            //TODO Put your UI Here
                        },
                        onError = {
                            //TODO Put your UI Here
                        }
                    )
                }
            }
        }
    }
}