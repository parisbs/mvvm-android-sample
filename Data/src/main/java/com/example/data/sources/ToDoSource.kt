package com.example.data.sources

import com.example.data.entities.ToDo
import com.example.data.entities.responses.SourceResponse
import kotlinx.coroutines.flow.Flow

interface ToDoSource {
    suspend fun getToDo(id: String) : Flow<SourceResponse<ToDo>>
}