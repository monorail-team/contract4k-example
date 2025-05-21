package com.example.demo.order.service.dto.response

import com.example.demo.customer.domain.Customer
import com.example.demo.global.Price
import com.example.demo.global.Quantity
import com.example.demo.order.domain.Order
import com.example.demo.order.domain.OrderProduct
import com.example.demo.order.domain.OrderStatus
import com.example.demo.product.service.dto.response.ProductResponse

data class CreateOrderResponse(
    val customer: Customer,
    val status: OrderStatus,
    val totalPrice: Price,
    val orderProducts: MutableList<OrderProduct>,
    val id: Long,
)

data class OrderProductResponse(
    val order: Order,
    val product: ProductResponse,
    val quantity: Quantity,
    val unitPrice: Price,
    val id: Long,
)