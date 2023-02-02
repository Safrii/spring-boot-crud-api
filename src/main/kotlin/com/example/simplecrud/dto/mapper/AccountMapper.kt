package com.example.simplecrud.dto.mapper

import com.example.simplecrud.dto.AccountDTO
import com.example.simplecrud.entity.Account
import org.springframework.stereotype.Component

@Component
class AccountMapper {
    fun mapToAccountDto(account: Account): AccountDTO {
        val accountDTO = AccountDTO()
        accountDTO.firstName = account.firstName
        accountDTO.lastName = account.lastName
        accountDTO.username = account.username
        accountDTO.email = account.email

        return accountDTO
    }

    fun mapToAccountResponseList(accountList: List<Account>): List<AccountDTO> {
        val accountListDTO = mutableListOf<AccountDTO>()
        accountList.forEach {
            accountListDTO.add(mapToAccountDto(it))
        }

        return accountListDTO
    }

    fun mapToAccountUpdate(account: Account): Account {
        val updatedAccount = Account()
        updatedAccount.id = account.id
        updatedAccount.firstName = account.firstName
        updatedAccount.lastName = account.lastName
        updatedAccount.username = account.username
        updatedAccount.email = account.email

        return updatedAccount
    }
}