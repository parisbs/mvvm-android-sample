package com.example.mvvmproject.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmproject.data.entities.ToDo
import com.example.mvvmproject.data.entities.responses.SourceResponse
import com.example.mvvmproject.domain.usecases.GetToDo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    private val backgroundDispatcher: CoroutineContext,
    private val getToDo: GetToDo
) : ViewModel() {

    private val toDoUnit = MutableLiveData<ToDoStatus>()
    val toDo: LiveData<ToDoStatus>
        get() = toDoUnit

    fun getToDoById(id: String) = viewModelScope.launch(backgroundDispatcher) {
        getToDo(id).collect { response ->
            when (response) {
                is SourceResponse.Success -> toDoUnit.postValue(ToDoStatus.Success(response.data))
                is SourceResponse.Failure -> toDoUnit.postValue(ToDoStatus.Failure)
            }
        }
    }

    sealed class ToDoStatus {
        class Success(val toDo: ToDo) : ToDoStatus()
        object Failure : ToDoStatus()
    }
}
