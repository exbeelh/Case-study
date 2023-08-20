package com.example.appqrispayment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appqrispayment.data.local.dao.TransactionDao
import com.example.appqrispayment.data.local.dao.UserDao
import com.example.appqrispayment.data.local.entity.TransactionEntity
import com.example.appqrispayment.data.local.entity.User

@Database(
    entities = [
        User::class,
        TransactionEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun transactionDao(): TransactionDao
}