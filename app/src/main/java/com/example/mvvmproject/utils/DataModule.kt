package com.example.mvvmproject.utils

import com.example.data.repositories.todo.ToDoRepository
import com.example.data.repositories.todo.ToDoRepositoryImpl
import com.example.data.sources.ToDoSource
import com.example.data.sources.remote.RemoteToDoSourceImpl

import org.koin.dsl.module

val dataModule = module {

    single<ToDoSource> {
        RemoteToDoSourceImpl()
    }

    single<ToDoRepository> {
        ToDoRepositoryImpl(get())
    }
}
