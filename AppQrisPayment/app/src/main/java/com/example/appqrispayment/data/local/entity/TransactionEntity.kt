package com.example.appqrispayment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val bank: String,
    val transactionId: String,
    val merchant: String,
    val nominal: Long
)
