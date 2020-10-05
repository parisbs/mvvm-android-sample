package com.example.mvvmproject.utils

import com.example.mvvmproject.data.repositories.todo.ToDoRepository
import com.example.mvvmproject.data.repositories.todo.ToDoRepositoryImpl
import com.example.mvvmproject.data.sources.ToDoSource
import com.example.mvvmproject.data.sources.remote.RemoteToDoSourceImpl
import org.koin.dsl.module

val dataModule = module {

    single<ToDoSource> {
        RemoteToDoSourceImpl()
    }

    single<ToDoRepository> {
        ToDoRepositoryImpl(get())
    }
}
