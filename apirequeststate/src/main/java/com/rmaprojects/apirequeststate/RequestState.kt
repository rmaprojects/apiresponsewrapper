package com.rmaprojects.apirequeststate

@Deprecated(
    message = "ResponseState is renamed to RequestState and will be removed in future, use CustomResponseState instead",
    replaceWith = ReplaceWith("ResponseState"),
)
sealed class RequestState<out T>: ResponseState<T>()