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
}