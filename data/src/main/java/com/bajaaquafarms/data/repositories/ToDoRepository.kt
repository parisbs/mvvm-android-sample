package com.bajaaquafarms.data.repositories

import com.bajaaquafarms.data.entities.ToDo
import com.bajaaquafarms.data.entities.responses.SourceResponse
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    suspend fun getToDo(id: String) : Flow<SourceResponse<ToDo>>
}