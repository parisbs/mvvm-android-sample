package com.example.data.entities.responses
//La clase sellada no solo puede crear clases y subclases y sus propios parametros,
// si no que tambien tenemos control total de los datos que suaremos
sealed class SourceResponse<out T> {
    object Loading : SourceResponse<Nothing>()
    //Si se encuentra la informacion buscada, se muestra
    //Aqui se recibe T para transformarlo en otra cosa
    class Success <T> (val data:T ) : SourceResponse<T>()
    //Con esta clase evitamos que crashee la app, sin embargo si recibimos el error
    class Failure (val throwable: Throwable ) : SourceResponse<Nothing>()
}