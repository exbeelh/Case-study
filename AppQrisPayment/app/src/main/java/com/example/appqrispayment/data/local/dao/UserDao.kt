package com.example.appqrispayment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appqrispayment.data.local.entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun createUser(user: User)

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Update
    suspend fun updateUser(user: User)
}