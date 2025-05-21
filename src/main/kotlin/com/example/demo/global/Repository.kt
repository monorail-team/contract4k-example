package com.example.demo.global

interface Repository<T> {

    fun findById(id: Long): T?
}