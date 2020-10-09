package com.bajaaquafarms.data.sources.remote

import com.bajaaquafarms.data.entities.ToDo
import com.bajaaquafarms.data.entities.responses.SourceResponse
import com.bajaaquafarms.data.sources.ToDoSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteToDoSourceImp: ToDoSource {
    override suspend fun getToDo(id: String): Flow<SourceResponse<ToDo>> = flow {
        emit(
            SourceResponse.Success(
                ToDo(
                    title = "Titulo $id",
                    message = "Este es un mensaje de ToDo $id"
                )
            )
        )
    }

}