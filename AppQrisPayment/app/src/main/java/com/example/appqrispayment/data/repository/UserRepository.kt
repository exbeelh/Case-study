package com.example.appqrispayment.data.repository

import com.example.appqrispayment.data.local.dao.UserDao
import com.example.appqrispayment.data.local.entity.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun createUser(user: User) {
        return userDao.createUser(user)
    }

    suspend fun getUser(userId: Int): User? {
        return userDao.getUserById(userId)
    }

    suspend fun updateUser(user: User) {
        return userDao.updateUser(user)
    }
}