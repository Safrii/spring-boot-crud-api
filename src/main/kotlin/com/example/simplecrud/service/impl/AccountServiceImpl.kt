package com.example.simplecrud.service.impl

import com.example.simplecrud.dto.mapper.AccountMapper
import com.example.simplecrud.entity.Account
import com.example.simplecrud.repository.AccountRepository
import com.example.simplecrud.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl constructor(
    private val accountRepository: AccountRepository,
    private val accountMapper: AccountMapper
) : AccountService {

    override fun createAccount(account: Account): Account {
        return accountRepository.save(account)
    }

    override fun getAccounts(): List<Account> {
        return accountRepository.findAll()
    }

    override fun getAccount(accountId: Long): Account {
        return accountRepository.findAccountById(accountId)
            ?: throw Exception("there is no account with specific id: $accountId")
    }

    override fun updateAccount(accountId: Long, update: Account): Account {
        var account = accountRepository.findAccountById(accountId)
            ?: throw Exception("there is no account with specific id: $accountId")
        update.id = account.id
        account = accountMapper.mapToAccountUpdate(update)

        return accountRepository.save(account)
    }

    override fun deleteAccount(accountId: Long) {
        val accountExists = accountRepository.existsById(accountId)
        if (accountExists) {
            accountRepository.deleteById(accountId)
        } else {
            throw Exception("there is no account with specific id: $accountId")
        }
    }
}