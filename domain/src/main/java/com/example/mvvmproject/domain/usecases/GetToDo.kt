package com.example.mvvmproject.domain.usecases

import com.example.mvvmproject.data.entities.ToDo
import com.example.mvvmproject.data.entities.responses.SourceResponse
import com.example.mvvmproject.data.repositories.todo.ToDoRepository
import kotlinx.coroutines.flow.Flow

class GetToDo(
    private val toDoRepository: ToDoRepository
) {
        suspend operator fun invoke(id: String): Flow<SourceResponse<ToDo>> =
        toDoRepository.getToDo(id)
}
