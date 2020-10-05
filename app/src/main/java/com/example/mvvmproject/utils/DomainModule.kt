package com.example.mvvmproject.utils

import com.example.mvvmproject.domain.usecases.GetToDo
import org.koin.dsl.module

val domainModule = module {
    factory { GetToDo(get()) }
}
