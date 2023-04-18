/* Banco Demo 2023 */
package com.banco.demo.commons.libs.networking

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module()
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
        fun provideRetrofitInstance(@ApplicationContext appContext: Context): Retrofit {
            return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            //.baseUrl("https://7c66227a-6433-44b4-89d2-c2ad1c329e32.mock.pstmn.io")
//            .baseUrl("https://devapiexp.clinicainternacional.com.pe")
            .client(provideOkHttpClient(appContext))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideOkHttpClient(appContext: Context): OkHttpClient {
        return OkHttpClient.Builder()
            //.addInterceptor(ConnectionInterceptor(appContext))
            .addInterceptor(provideLoggingInterceptor())
            .callTimeout(3, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .build()
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return logging
    }


}
