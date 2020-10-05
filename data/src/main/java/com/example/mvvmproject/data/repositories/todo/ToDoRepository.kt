package com.example.mvvmproject.data.repositories.todo

import com.example.mvvmproject.data.entities.ToDo
import com.example.mvvmproject.data.entities.responses.SourceResponse
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    suspend fun getToDo(id: String) : Flow<SourceResponse<ToDo>>
}
