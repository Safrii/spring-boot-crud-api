package com.example.simplecrud.controller

import com.example.simplecrud.dto.AccountDTO
import com.example.simplecrud.dto.mapper.AccountMapper
import com.example.simplecrud.entity.Account
import com.example.simplecrud.service.AccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AccountController constructor(
    private val accountService: AccountService,
    private val accountMapper: AccountMapper
) {

    @PostMapping("/account")
    fun createAccount(@RequestBody account: Account): ResponseEntity<AccountDTO> {
        return ResponseEntity.ok(
            accountMapper.mapToAccountDto(
                accountService.createAccount(account)
            )
        )
    }
}