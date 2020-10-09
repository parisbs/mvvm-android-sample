package com.bajaaquafarms.domain.usecases

import com.bajaaquafarms.data.entities.ToDo
import com.bajaaquafarms.data.entities.responses.SourceResponse
import com.bajaaquafarms.data.repositories.ToDoRepository
import kotlinx.coroutines.flow.Flow

class GetToDo (
    private val toDoRepository: ToDoRepository
) {
    suspend operator fun invoke(id: String): Flow<SourceResponse<ToDo>> =
        toDoRepository.getToDo(id)
}