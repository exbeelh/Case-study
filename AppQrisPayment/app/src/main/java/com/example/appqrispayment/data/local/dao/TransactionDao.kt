package com.example.appqrispayment.data.local.dao

import androidx.room.Dao
import androidx.room.Query

import androidx.room.Upsert
import com.example.appqrispayment.data.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Upsert
    suspend fun upsertTransaction(transactionEntity: TransactionEntity)

    @Query("SELECT * FROM transactions ORDER BY id DESC")
    fun getTransactionHistory(): Flow<List<TransactionEntity>>
}