package com.example.simplecrud.repository

import com.example.simplecrud.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {

    fun findAccountById(accountId: Long): Account?
}