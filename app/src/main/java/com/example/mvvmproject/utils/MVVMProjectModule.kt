package com.example.mvvmproject.utils

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

const val BACKGROUND_DISPATCHER = "backgroundDispatcher"

val mvvmProjectModule = module {
    single<CoroutineContext>(named(BACKGROUND_DISPATCHER)) {
        Dispatchers.Default
    }
}
