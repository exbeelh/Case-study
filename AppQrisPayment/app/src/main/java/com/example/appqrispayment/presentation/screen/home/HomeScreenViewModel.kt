package com.example.appqrispayment.presentation.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appqrispayment.data.local.entity.TransactionEntity
import com.example.appqrispayment.data.local.entity.User
import com.example.appqrispayment.data.repository.TransactionRepository
import com.example.appqrispayment.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    private val _userData = MutableLiveData<User>()
    val userData: LiveData<User>
        get() = _userData

    init {
        viewModelScope.launch {
            val existingUser = userRepository.getUser(1)
            if (existingUser == null) {
                userRepository.createUser(User(1, "John Cena", 1000000))
            }
            val user = userRepository.getUser(1)
            _userData.value = user!!
        }
    }

    fun performTransaction(transactionAmount: Long) {
        viewModelScope.launch {
            val user = _userData.value ?: return@launch
            if (user.balance >= transactionAmount) {
                val updatedUser = user.copy(balance = user.balance - transactionAmount)
                userRepository.updateUser(updatedUser)
                _userData.value = updatedUser
            }
        }
    }

    fun saveTransaction(transaction: TransactionEntity) {
        viewModelScope.launch {
            transactionRepository.createTransaction(transaction)
        }
    }
}