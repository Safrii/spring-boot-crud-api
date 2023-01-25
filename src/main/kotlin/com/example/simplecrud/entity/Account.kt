package com.example.simplecrud.entity

import jakarta.persistence.*


@Entity
@Table(name = "accounts")
class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column(name = "username")
    var username: String? = null

    @Column(name = "email")
    var email: String? = null
}