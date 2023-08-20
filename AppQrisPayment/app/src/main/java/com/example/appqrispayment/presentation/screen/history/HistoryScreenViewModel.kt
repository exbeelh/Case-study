package com.example.appqrispayment.presentation.screen.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appqrispayment.data.local.entity.TransactionEntity
import com.example.appqrispayment.data.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryScreenViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    val transactions: Flow<List<TransactionEntity>> = transactionRepository.getTransactionHistory()
}