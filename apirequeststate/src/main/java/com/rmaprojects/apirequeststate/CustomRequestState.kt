package com.rmaprojects.apirequeststate

@Deprecated(
    message = "CustomRequestState is renamed to CustomResponseState and will be removed in future, use CustomResponseState instead",
    replaceWith = ReplaceWith("CustomResponseState")
)
sealed class CustomRequestState<out T>: CustomResponseState<T>()