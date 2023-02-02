package com.example.simplecrud.controller

import com.example.simplecrud.dto.AccountDTO
import com.example.simplecrud.dto.mapper.AccountMapper
import com.example.simplecrud.entity.Account
import com.example.simplecrud.service.AccountService
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class AccountController constructor(
    private val accountService: AccountService,
    private val accountMapper: AccountMapper
) {
    @GetMapping("/account")
    fun getAccounts(): ResponseEntity<List<AccountDTO>> {
        return ResponseEntity.ok(
            accountMapper.mapToAccountResponseList(
                accountService.getAccounts()
            )
        )
    }

    @GetMapping("/account/{id}")
    fun getAccount(@PathVariable id: Long): ResponseEntity<AccountDTO>{
        return ResponseEntity.ok(
            accountMapper.mapToAccountDto(
                accountService.getAccount(id)
            )
        )
    }

    @PostMapping("/account")
    fun createAccount(@RequestBody account: Account): ResponseEntity<AccountDTO> {
        return ResponseEntity.ok(
            accountMapper.mapToAccountDto(
                accountService.createAccount(account)
            )
        )
    }

    @PatchMapping("/account/{id}")
    fun updateAccount(@PathVariable id: Long, @RequestBody account: Account): ResponseEntity<AccountDTO> {
        return ResponseEntity.ok(
            accountMapper.mapToAccountDto(
                accountService.updateAccount(id, account)
            )
        )
    }

    @DeleteMapping("/account/{id}")
    fun deleteAccount(@PathVariable id: Long) {
        accountService.deleteAccount(id)
    }
}