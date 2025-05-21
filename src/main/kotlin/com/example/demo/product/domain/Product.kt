package com.example.demo.product.domain

import java.util.concurrent.atomic.AtomicLong

class Product(
    var name: String,
    var price: Int,
    var stock: Int,
    var category: ProductCategory,
    var status: ProductStatus = ProductStatus.AVAILABLE,
    val id: Long = nextId(),
) {

    companion object {
        private val idSequence = AtomicLong(1L)

        fun nextId(): Long = idSequence.getAndIncrement()

        fun of(name: String, price: Int, stock: Int, category: ProductCategory): Product {
            return Product(
                name = name,
                price = price,
                stock = stock,
                category = category,
            )
        }
    }

    fun deductStock(stock: Int) : Int{
        require(this.stock >= stock) { "재고 보다 많은 수량을 구매 할 수 없습니다." }

        this.stock -= stock

        if(this.stock == 0){
            status = ProductStatus.SOLD_OUT
        }

        require(this.stock >= 0) { "재고는 음수가 될 수 없습니다." }
        return this.stock
    }
}
