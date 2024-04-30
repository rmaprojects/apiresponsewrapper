package com.rmaprojects.apirequeststate

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

sealed class RequestState<out T> {
    data object Idle : RequestState<Nothing>()
    data object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(val message: String) : RequestState<Nothing>()

    fun isLoading() = this is Loading
    fun isSuccess() = this is Success
    fun isError() = this is Error

    /**
     * Returns data from a [Success].
     * @throws ClassCastException If the current state is not [Success]
     *  */
    fun getSuccessData() = (this as Success).data
    fun getSuccessDataOrNull(): T? {
        return try {
            (this as Success).data
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Returns an error message from an [Error]
     * @throws ClassCastException If the current state is not [Error]
     *  */
    fun getErrorMessage() = (this as Error).message
    fun getErrorMessageOrNull(): String? {
        return try {
            (this as Error).message
        } catch (e: Exception) {
            null
        }
    }

    @Composable
    fun DisplayResult(
        modifier: Modifier = Modifier,
        onIdle: (@Composable () -> Unit)? = null,
        onLoading: @Composable () -> Unit,
        onSuccess: @Composable (data: T) -> Unit,
        onError: @Composable (message: String) -> Unit,
        label: String = "Content Animation"
    ) {
        AnimatedContent(
            modifier = modifier,
            targetState = this,
            transitionSpec = {
                fadeIn(tween(durationMillis = 300)) togetherWith fadeOut(tween(durationMillis = 300))
            },
            label = label
        ) { state ->
            when (state) {
                is Idle -> {
                    onIdle?.invoke()
                }

                is Loading -> {
                    onLoading()
                }

                is Success -> {
                    onSuccess(state.data)
                }

                is Error -> {
                    onError(state.message)
                }
            }
        }
    }
}