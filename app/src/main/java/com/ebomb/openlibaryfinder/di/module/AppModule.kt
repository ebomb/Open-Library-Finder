package com.ebomb.openlibaryfinder.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit

@Module
class AppModule {

    private var timeoutInSeconds = 10.toLong()
    private lateinit var application: Application

    fun AppModule(application: Application) {
        this.application = application
    }

    @Provides
    fun provideTrustedOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(httpLoggingInterceptor)
        builder.readTimeout(timeoutInSeconds, TimeUnit.SECONDS)
        builder.connectTimeout(timeoutInSeconds, TimeUnit.SECONDS)
        builder.writeTimeout(timeoutInSeconds, TimeUnit.SECONDS)
        return builder.build()
    }

//    @Provides
//    OpenGraphApi providesOpenGraphApi() {
//
//    }
}