package com.example.domain.usecases


import com.example.data.entities.ToDo
import com.example.data.entities.responses.SourceResponse
import com.example.data.repositories.todo.ToDoRepository
import kotlinx.coroutines.flow.Flow

class GetToDo(
    //Se instancia de la clase repositories
    private val toDoRepository: ToDoRepository
) {
    //Para que es esta funcion?
    suspend operator fun invoke(id: String): Flow<SourceResponse<ToDo>> =
        toDoRepository.getToDo(id)
}