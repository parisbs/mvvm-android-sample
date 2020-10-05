package com.example.mvvmproject.main

import com.example.mvvmproject.utils.BACKGROUND_DISPATCHER
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainModule = module {

    single {
        MainViewModel(
            get(named(BACKGROUND_DISPATCHER)),
            get()
        )
    }
}
