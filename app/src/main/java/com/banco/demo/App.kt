/* Banco Demo 2023 */
package com.banco.demo

import android.app.Application
import com.banco.demo.commons.libs.networking.NetworkingApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(), NetworkingApp {
    private var idTransaction: String = "12121212"

    override fun setIdTransaction(idTransaction: String) {
        this.idTransaction = idTransaction
    }

    override fun getIdTransaction(): String {
        return this.idTransaction
    }
}
