package com.example.data.remote.utils

import com.example.core.exception.GenericErrorException
import com.example.core.exception.NetworkErrorException
import com.example.core.exception.ServerErrorException
import com.example.core.utils.Result
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> dataWrapper(call: suspend () -> T): Result<T> {
    return try {
        return Result.Success(call())
    } catch (ioException: IOException) {
        Result.Error(NetworkErrorException())
    } catch (httpException: HttpException) {
        Result.Error(ServerErrorException())
    } catch (throwable: Throwable) {
        Result.Error(GenericErrorException())
    }
}