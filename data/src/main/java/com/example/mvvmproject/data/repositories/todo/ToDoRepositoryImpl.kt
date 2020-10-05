package com.example.mvvmproject.data.repositories.todo

import com.example.mvvmproject.data.entities.ToDo
import com.example.mvvmproject.data.entities.responses.SourceResponse
import com.example.mvvmproject.data.sources.ToDoSource
import kotlinx.coroutines.flow.Flow

class ToDoRepositoryImpl(
    private val toDoSource: ToDoSource
) : ToDoRepository {
    override suspend fun getToDo(id: String): Flow<SourceResponse<ToDo>> = toDoSource.getToDo(id)
}
