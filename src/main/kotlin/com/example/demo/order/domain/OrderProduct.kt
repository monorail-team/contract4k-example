package com.example.demo.order.domain

import com.example.demo.global.*
import com.example.demo.product.domain.Product
import java.util.concurrent.atomic.AtomicLong

class OrderProduct(
    val order: Order,
    val product: Product,
    val quantity: Quantity,
    val unitPrice: Price,
    val id: Long = nextId()
) {

    companion object {
        private val idSequence = AtomicLong(1L)

        fun nextId(): Long = idSequence.getAndIncrement()

        fun of(order: Order, product: Product, quantity: Quantity): OrderProduct {
            val orderProduct = OrderProduct(
                order = order,
                product = product,
                quantity = quantity,
                unitPrice = Price(product.price)
            )
            order.addOrderProduct(orderProduct)
            order.updateTotalPrice(order.totalPrice + orderProduct.getTotalPrice())
            product.deductStock(quantity.value)
            return orderProduct
        }
    }

    fun getTotalPrice(): Price {
        return Price(unitPrice.value * quantity.value)
    }
}