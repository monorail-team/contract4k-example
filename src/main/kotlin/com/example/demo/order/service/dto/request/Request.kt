package com.example.demo.order.service.dto.request

data class CreateOrderRequest(
    val customerId: Long,
    val products: List<OrderProductRequest>
) {

    companion object {
        fun of(customerId: Long, products: List<OrderProductRequest>): CreateOrderRequest {
            return CreateOrderRequest(customerId, products)
        }
    }
}

data class OrderProductRequest(
    val productId: Long,
    val quantity: Int,
    val price: Int
)
