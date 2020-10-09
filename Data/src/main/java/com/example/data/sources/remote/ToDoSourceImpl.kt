package com.example.data.sources.remote

import com.example.data.entities.ToDo
import com.example.data.entities.responses.SourceResponse
import com.example.data.sources.ToDoSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//Se crea la implementacion de la inferfaz hecha en sources
class RemoteToDoSourceImpl : ToDoSource {
    //Se sobre escribe la funcion suspendida en la intefaz
    override suspend fun getToDo(id: String): Flow<SourceResponse<ToDo>> = flow{
        //Emit se usa para recolectar el valor emitido upstram -> Aun no me queda claro :(
        emit(
            SourceResponse.Success(
                ToDo(
                    title = "$id",
                    message = "This is the message of to do $id"
                )
            )
        )

    }
}



