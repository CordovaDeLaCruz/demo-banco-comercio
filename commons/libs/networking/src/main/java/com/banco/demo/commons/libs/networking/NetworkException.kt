package com.banco.demo.commons.libs.networking

import java.io.IOException

class NetworkException(var code: String, message: String) : IOException(message) {


    companion object {
        val ERROR_GENERAL = "999999"
        val ERROR_CONECTION_INTERNET = "999998"
    }

}