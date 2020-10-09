package com.example.mvvmproject.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bajaaquafarms.data.entities.ToDo
import com.bajaaquafarms.data.entities.responses.SourceResponse
import com.bajaaquafarms.domain.usecases.GetToDo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel (
    private val bkgDispatcher: CoroutineContext,
    private val getToDo: GetToDo
) : ViewModel() {

    private val toDoUnit = MutableLiveData<ToDoStatus>()
    val todo: LiveData<ToDoStatus> get() = toDoUnit

    fun getToDoById(id: String) = viewModelScope.launch(bkgDispatcher) {
        getToDo(id).collect { response ->
            when (response) {
                is SourceResponse.Success -> toDoUnit.postValue(ToDoStatus.Sucess(response.data))
                is SourceResponse.Failure -> toDoUnit.postValue(ToDoStatus.Failure)
            }
        }
    }


    sealed class ToDoStatus {
        class Sucess(val todo: ToDo) : ToDoStatus()
        object Failure : ToDoStatus()
    }

}