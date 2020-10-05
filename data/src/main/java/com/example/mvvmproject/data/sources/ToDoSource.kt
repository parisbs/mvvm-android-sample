package com.example.mvvmproject.data.sources

import com.example.mvvmproject.data.entities.ToDo
import com.example.mvvmproject.data.entities.responses.SourceResponse
import kotlinx.coroutines.flow.Flow

interface ToDoSource {
    suspend fun getToDo(id: String): Flow<SourceResponse<ToDo>>
}
