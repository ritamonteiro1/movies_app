package com.example.data.remote.utils

import com.example.core.exception.GenericErrorException
import com.example.core.exception.NetworkErrorException
import com.example.core.exception.ServerErrorException
import retrofit2.HttpException
import java.io.IOException

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val error: Throwable) : Result<T>()

    companion object {
        suspend fun <T> guard(call: suspend () -> T): Result<T> {
            return try {
                return Success(call())
            } catch (ioException: IOException) {
                Error(NetworkErrorException())
            } catch (httpException: HttpException) {
                Error(ServerErrorException())
            } catch (throwable: Throwable) {
                Error(GenericErrorException())
            }
        }
    }
}