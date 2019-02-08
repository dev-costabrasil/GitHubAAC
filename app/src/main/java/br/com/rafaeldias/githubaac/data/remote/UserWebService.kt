package br.com.rafaeldias.githubaac.data.remote

import br.com.rafaeldias.githubaac.data.local.entity.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface UserWebService {
    @GET("users/{user}")
    fun getUser(@Path("user") userId: String) : Call<User>
}