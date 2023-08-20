package com.example.appqrispayment.di

import com.example.appqrispayment.data.local.AppDatabase
import com.example.appqrispayment.data.repository.TransactionRepository
import com.example.appqrispayment.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(database: AppDatabase): UserRepository {
        return UserRepository(database.userDao())
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(database: AppDatabase): TransactionRepository {
        return TransactionRepository(database.transactionDao())
    }
}