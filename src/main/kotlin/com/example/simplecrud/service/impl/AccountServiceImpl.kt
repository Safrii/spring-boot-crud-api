package com.example.simplecrud.service.impl

import com.example.simplecrud.entity.Account
import com.example.simplecrud.repository.AccountRepository
import com.example.simplecrud.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl constructor(
    private val accountRepository: AccountRepository
) : AccountService {

    override fun createAccount(account: Account): Account {
        return accountRepository.save(account)
    }

    override fun getAccounts(): List<Account> {
        TODO("Not yet implemented")
    }

    override fun getAccount(accountId: Long): Account {
        TODO("Not yet implemented")
    }

    override fun updateAccount(accountId: Long, update: Account) {
        TODO("Not yet implemented")
    }

    override fun deleteAccount(accountId: Long) {
        TODO("Not yet implemented")
    }
}