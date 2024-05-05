package com.rmaprojects.apirequeststate

@Deprecated(
    message = "RequestState is renamed to ResponseState and will be removed in future, use ResponseState instead",
    replaceWith = ReplaceWith("ResponseState"),
)
sealed class RequestState<out T>: ResponseState<T>()
