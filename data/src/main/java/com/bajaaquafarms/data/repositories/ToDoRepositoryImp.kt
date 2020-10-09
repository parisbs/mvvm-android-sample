package com.bajaaquafarms.data.repositories

import com.bajaaquafarms.data.entities.ToDo
import com.bajaaquafarms.data.entities.responses.SourceResponse
import com.bajaaquafarms.data.sources.ToDoSource
import kotlinx.coroutines.flow.Flow

class ToDoRepositoryImp (
    private val toDoSource: ToDoSource
) : ToDoRepository {
    override suspend fun getToDo(id: String): Flow<SourceResponse<ToDo>> = toDoSource.getToDo(id)

}