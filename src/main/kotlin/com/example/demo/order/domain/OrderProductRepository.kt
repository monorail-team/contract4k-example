package com.example.demo.order.domain

import com.example.demo.global.Repository

class OrderProductRepository : Repository<OrderProduct> {

    companion object {
        private val orderProductMap = mutableMapOf<Long, OrderProduct>()
    }

    fun save(orderProduct: OrderProduct): OrderProduct {
        orderProductMap[orderProduct.id] = orderProduct
        return orderProduct
    }

    override fun findById(id: Long): OrderProduct? {
        return orderProductMap[id]
    }

    fun findAll(): List<OrderProduct> {
        return orderProductMap.values.toList()
    }

    fun deleteById(id: Long) {
        orderProductMap.remove(id)
    }

    fun clear() {
        orderProductMap.clear()
    }
}