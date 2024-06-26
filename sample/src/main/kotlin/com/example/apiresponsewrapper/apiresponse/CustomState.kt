package com.example.apiresponsewrapper.apiresponse

import androidx.compose.runtime.Composable
import com.rmaprojects.apirequeststate.CustomResponseState

sealed class CustomState<out T>: CustomResponseState<T>() {

    /**
     * Here you can add your own Custom State for your screen, api, etc.
     */

    data object Initializing: CustomState<Nothing>()

    /**
     * Also you can edit your own Error Message here
     */
    override fun getErrorMessage(): String {
        return super.getErrorMessage()
    }

    /**
     * Or, you can add your own custom UI here
     */
    @Composable
    fun CustomUi() {

    }
}