package com.example.demo.order.domain

import com.example.demo.customer.domain.Customer
import com.example.demo.global.Price
import java.util.concurrent.atomic.AtomicLong

class Order(
    val customer: Customer,
    var status: OrderStatus = OrderStatus.CREATED,
    var totalPrice: Price = Price(0),
    val orderProducts: MutableList<OrderProduct> = mutableListOf(),
    val id: Long = nextId(),
) {

    companion object {
        private val idSequence = AtomicLong(1L)

        fun nextId(): Long = idSequence.getAndIncrement()

        fun of(customer: Customer, orderProductInputs: List<OrderProduct>): Order {
            val order = Order(customer = customer)

            var total = Price(0)

            orderProductInputs.forEach { orderProduct ->
                order.addOrderProduct(orderProduct)
                total += orderProduct.getTotalPrice()
            }

            order.updateTotalPrice(total)
            return order
        }
    }

    fun addOrderProduct(orderProduct: OrderProduct) {
        orderProducts.add(orderProduct)
    }

    fun updateTotalPrice(price: Price) {
        totalPrice = price
    }
}
