package com.example.data.repositories.todo

import com.example.data.entities.ToDo
import com.example.data.entities.responses.SourceResponse
import com.example.data.sources.ToDoSource
import kotlinx.coroutines.flow.Flow

class ToDoRepositoryImpl(
    //Se instancia un objeto de la calse ToDoSource
    private val toDoSource: ToDoSource
) // Se implementa la interfaz hecha
     : ToDoRepository{
    //Se sobre escribe la funcion de la interfaz hecha y se asigna al objeto creado
    override suspend fun getToDo(id: String): Flow<SourceResponse<ToDo>> = toDoSource.getToDo(id)
}