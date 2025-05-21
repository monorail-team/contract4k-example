package com.example.demo.product.domain

import com.example.demo.global.Repository

class ProductRepository : Repository<Product> {

    companion object {
        private val productMap = mutableMapOf<Long, Product>()
    }

    fun save(product: Product): Product {
        productMap[product.id] = product
        return product
    }

    override fun findById(id: Long): Product? {
        return productMap[id]
    }

    fun findAll(): List<Product> {
        return productMap.values.toList()
    }

    fun findAllByIdIn(ids: List<Long>): List<Product> {
        return ids.mapNotNull { id -> productMap[id] }
    }

    fun deleteById(id: Long) {
        productMap.remove(id)
    }

    fun clear() {
        productMap.clear()
    }
}