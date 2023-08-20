package com.example.appqrispayment.data.repository

import com.example.appqrispayment.data.local.dao.TransactionDao
import com.example.appqrispayment.data.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val transactionDao: TransactionDao
) {
    suspend fun createTransaction(transactionEntity: TransactionEntity) {
        transactionDao.upsertTransaction(transactionEntity)
    }

    fun getTransactionHistory(): Flow<List<TransactionEntity>> {
       return transactionDao.getTransactionHistory()
    }
}