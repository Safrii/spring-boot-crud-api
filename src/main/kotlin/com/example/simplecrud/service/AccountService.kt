package com.example.simplecrud.service

import com.example.simplecrud.entity.Account

interface AccountService {

    fun createAccount(account: Account): Account

    fun getAccounts(): List<Account>

    fun getAccount(accountId: Long): Account

    fun updateAccount(accountId: Long, update: Account)

    fun deleteAccount(accountId: Long)
}