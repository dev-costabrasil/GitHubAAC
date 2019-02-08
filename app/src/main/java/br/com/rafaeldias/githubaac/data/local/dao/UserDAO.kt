package br.com.rafaeldias.githubaac.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import br.com.rafaeldias.githubaac.data.local.entity.User
import java.util.*

@Dao
interface UserDAO {
    @Insert(onConflict = REPLACE) //Se tentar fazer um insert no banco local de um registro que ja existe, ele atualiza
    fun save(user: User)

    @Query("SELECT * FROM user WHERE login = :login")
    fun load(login: String) : LiveData<User>

    @Query("SELECT * FROM user WHERE login = :login AND lastRefresh = :lastRefresh LIMIT 1")
    fun hasUser(login: String, lastRefresh: Date): User
}