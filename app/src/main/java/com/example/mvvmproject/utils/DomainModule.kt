package com.example.mvvmproject.utils

import com.example.domain.usecases.GetToDo

import org.koin.dsl.module

val domainModule = module {
    factory { GetToDo(get()) }
}
