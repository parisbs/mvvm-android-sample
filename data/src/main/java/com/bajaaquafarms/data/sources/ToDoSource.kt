package com.bajaaquafarms.data.sources

import com.bajaaquafarms.data.entities.ToDo
import com.bajaaquafarms.data.entities.responses.SourceResponse
import kotlinx.coroutines.flow.Flow

interface ToDoSource {
    suspend fun  getToDo(id: String): Flow<SourceResponse<ToDo>>
}