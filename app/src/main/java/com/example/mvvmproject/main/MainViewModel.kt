package com.example.mvvmproject.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.entities.ToDo
import com.example.data.entities.responses.SourceResponse
import com.example.domain.usecases.GetToDo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class MainViewModel(
    private val backgroundDispatcher: CoroutineContext, //contexto de corutina por inyeccion de dependencias
    //Es una instancia de la clase que hicimos en el dominio
    private val getToDo: GetToDo //usecases
) : ViewModel() {

    private val toDoUnit = MutableLiveData<ToDoStatus>() // vamos a alojar el to do
    val toDo: LiveData<ToDoStatus>// Escucha todo el tiempo por el live data
        get() = toDoUnit // para cuando refaroctirecemos algo, cunado querramos acutalizar algo

    //flow deriva de una corutina adminisstrada, es un wrapper, por ser corutina se usa una suspend function
    //el metodo invoke es como un puntero para que cada vez que invocamos una funcion se ejecute otra
    //el view modelscope es para lanzar la corutina mediante inyeccion de dependencias
    // haciendo este metod
    fun getToDoById(id: String) = viewModelScope.launch(backgroundDispatcher) {
        //collect es el metodo que usa para llamar a los flows
        getToDo(id).collect { response ->
            when (response) {
                //succes pasa el valor a toDoUnit para refrescar la vista
                is SourceResponse.Success -> toDoUnit.postValue(ToDoStatus.Success(response.data))
                // <*>
                is SourceResponse.Failure -> toDoUnit.postValue(ToDoStatus.Failure)
                //Estas responses les responden al livedata

            }
        }
    }

    sealed class ToDoStatus {
        class Success(val toDo: ToDo) : ToDoStatus()
        object Failure : ToDoStatus()
    }
}