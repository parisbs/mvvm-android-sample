package com.example.data.repositories.todo

import com.example.data.entities.ToDo
//Se importa las responses hechas en entities
import com.example.data.entities.responses.SourceResponse
//Se importa la clase Flow. Se debe de implementar la libreria implementation
// 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9' en el build gradle para usar las corutinas

import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    suspend fun getToDo(id:String) : Flow<SourceResponse<ToDo>>
}