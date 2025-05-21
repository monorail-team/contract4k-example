package com.example.demo.order.domain

import com.example.demo.global.Repository

class OrderRepository : Repository<Order> {

    companion object {
        private val orderMap = mutableMapOf<Long, Order>()
    }

    fun save(order: Order): Order {
        orderMap[order.id] = order
        return order
    }

    override fun findById(id: Long): Order? {
        return orderMap[id]
    }

    fun findAll(): List<Order> {
        return orderMap.values.toList()
    }

    fun deleteById(id: Long) {
        orderMap.remove(id)
    }

    fun clear() {
        orderMap.clear()
    }
}