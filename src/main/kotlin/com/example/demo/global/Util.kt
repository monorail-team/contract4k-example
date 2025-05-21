package com.example.demo.global

fun fail(message: String): Nothing {
    throw NoSuchElementException(message)
}

fun <T> Repository<T>.findByIdOrThrow(id: Long, message: () -> String): T {
    return this.findById(id) ?: fail(message())
}