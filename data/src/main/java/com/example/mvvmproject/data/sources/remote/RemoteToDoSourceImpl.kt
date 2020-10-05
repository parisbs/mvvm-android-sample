package com.example.mvvmproject.data.sources.remote

import com.example.mvvmproject.data.entities.ToDo
import com.example.mvvmproject.data.entities.responses.SourceResponse
import com.example.mvvmproject.data.sources.ToDoSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteToDoSourceImpl : ToDoSource {

    override suspend fun getToDo(id: String): Flow<SourceResponse<ToDo>> = flow {
        emit(
            SourceResponse.Success(
                ToDo(
                    title = "Title $id",
                    message = "This is the message of to do $id"
                )
            )
        )
    }
}
