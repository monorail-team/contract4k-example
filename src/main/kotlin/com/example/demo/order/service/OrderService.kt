package com.example.demo.order.service

import com.example.demo.order.domain.OrderProductRepository
import com.example.demo.order.service.dto.response.CreateOrderResponse
import com.example.demo.order.domain.OrderRepository
import com.example.demo.order.service.dto.request.CreateOrderRequest
import com.example.demo.product.domain.Product
import com.example.demo.product.domain.ProductRepository

class OrderService(
    private val orderRepository: OrderRepository,
    private val orderProductRepository: OrderProductRepository,
    private val productRepository: ProductRepository,
) {

    fun createOrder(request: CreateOrderRequest): CreateOrderResponse {
        require(request.products.isNotEmpty()) { "There must be at least one product in order" }

        val products = productRepository.findAllByIdIn(request.products.map { it.productId })
        val productMap: Map<Long, Product> = products.associateBy { it.id }
        TODO()
    }
}