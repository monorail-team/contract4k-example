package com.example.demo.customer.domain

import com.example.demo.global.Repository

class CustomerRepository : Repository<Customer> {

    companion object {
        private val customerMap = mutableMapOf<Long, Customer>()
    }

    fun save(customer: Customer): Customer {
        customerMap[customer.id] = customer
        return customer
    }

    override fun findById(id: Long): Customer? {
        return customerMap[id]
    }

    fun findAll(): List<Customer> {
        return customerMap.values.toList()
    }

    fun deleteById(id: Long) {
        customerMap.remove(id)
    }

    fun clear() {
        customerMap.clear()
    }
}