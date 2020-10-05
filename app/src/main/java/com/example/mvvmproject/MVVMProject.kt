package com.example.mvvmproject

import android.app.Application
import com.example.mvvmproject.main.mainModule
import com.example.mvvmproject.utils.dataModule
import com.example.mvvmproject.utils.domainModule
import com.example.mvvmproject.utils.mvvmProjectModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MVVMProject : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeDependencyInjection(this)
    }

    private fun initializeDependencyInjection(application: Application) {
        startKoin {
            androidContext(application)
            androidLogger()
            androidFileProperties()
            modules(
                listOf(
                    mvvmProjectModule,
                    dataModule,
                    domainModule,
                    mainModule
                )
            )
        }
    }
}
