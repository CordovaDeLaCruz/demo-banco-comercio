package com.banco.demo.ui.util

import android.util.Log

object LogUtil {

    private val TAG = LogUtil::class.java.simpleName
    private const val showLog = false

    fun v(psTAG: String, psMessage: String?) {
        var psTAGAux = psTAG
        if (com.banco.demo.ui.BuildConfig.DEBUG || showLog) {
            if (showLog) {
                psTAGAux = "Clinica-$psTAGAux"
            }
            Log.v(psTAGAux, psMessage!!)
        }
    }

    fun d(psTAG: String, psMessage: String?) {
        var psTAGAux = psTAG
        if (com.banco.demo.ui.BuildConfig.DEBUG || showLog) {
            if (showLog) {
                psTAGAux = "Clinica-$psTAGAux"
            }
            Log.d(psTAGAux, psMessage!!)
        }
    }

    fun i(psTAG: String, psMessage: String?) {
        var psTAGAux = psTAG
        if (com.banco.demo.ui.BuildConfig.DEBUG || showLog) {
            if (showLog) {
                psTAGAux = "Clinica-$psTAGAux"
            }
            Log.i(psTAGAux, psMessage!!)
        }
    }

    fun w(psTAG: String, psMessage: String?) {
        var psTAGAux = psTAG
        if (com.banco.demo.ui.BuildConfig.DEBUG || showLog) {
            if (showLog) {
                psTAGAux = "Clinica-$psTAGAux"
            }
            Log.w(psTAGAux, psMessage!!)
        }
    }

    fun e(psTAG: String, psMessage: String?) {
        var psTAGAux = psTAG
        if (com.banco.demo.ui.BuildConfig.DEBUG || showLog) {
            if (showLog) {
                psTAGAux = "Clinica-$psTAGAux"
            }
            Log.e(psTAGAux, psMessage!!)
        }
    }

    fun e(psTAG: String, psMessage: String?, poException: Throwable?) {
        var psTAGAux = psTAG
        if (com.banco.demo.ui.BuildConfig.DEBUG || showLog) {
            if (showLog) {
                psTAGAux = "Clinica-$psTAGAux"
            }
            Log.e(psTAGAux, psMessage, poException)
        }
    }
}