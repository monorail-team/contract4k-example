package com.example.demo

import com.example.demo.customer.domain.CustomerRepository
import com.example.demo.customer.service.CustomerService
import com.example.demo.customer.service.dto.request.CreatCustomerRequest
import com.example.demo.global.Email
import com.example.demo.global.PhoneNumber
import com.example.demo.order.domain.OrderProductRepository
import com.example.demo.order.domain.OrderRepository
import com.example.demo.order.service.OrderService
import com.example.demo.product.domain.ProductCategory
import com.example.demo.product.domain.ProductRepository
import com.example.demo.product.service.ProductService
import com.example.demo.product.service.dto.request.CreateProductRequest

fun main() {
    val customerRepository = CustomerRepository()
    val orderRepository = OrderRepository()
    val productRepository = ProductRepository()
    val orderProductRepository = OrderProductRepository()

    val customerService = CustomerService(customerRepository)
    val productService = ProductService(productRepository)
    val orderService = OrderService(orderRepository, orderProductRepository, productRepository)

    init()

}

fun init() {
    val customerRepository = CustomerRepository()
    val orderRepository = OrderRepository()
    val productRepository = ProductRepository()
    val orderProductRepository = OrderProductRepository()

    val customerService = CustomerService(customerRepository)
    val productService = ProductService(productRepository)
    val orderService = OrderService(orderRepository, orderProductRepository, productRepository)

    customerService.createCustomer(
        CreatCustomerRequest(
            name = "김싸피",
            email = Email("ssafy1@ssafy.com"),
            phoneNumber = PhoneNumber("010-1234-1111"),
            address = "서울특별시 강남구 테헤란로 212",
            zipCode = "06220"
        ))
    customerService.createCustomer(
        CreatCustomerRequest(
            name = "이싸피",
            email = Email("ssafy2@ssafy.com"),
            phoneNumber = PhoneNumber("010-1234-2222"),
            address = "서울특별시 강남구 테헤란로 212",
            zipCode = "06220"
        ))
    customerService.createCustomer(
        CreatCustomerRequest(
            name = "최싸피",
            email = Email("ssafy3@ssafy.com"),
            phoneNumber = PhoneNumber("010-1234-3333"),
            address = "서울특별시 강남구 테헤란로 212",
            zipCode = "06220"
        ))

    productService.createProduct(
        CreateProductRequest(
            name = "김밥",
            price = 4000,
            category = ProductCategory.FOOD,
            stock = 10
        )
    )
    productService.createProduct(
        CreateProductRequest(
            name = "Effective Kotlin",
            price = 28000,
            category = ProductCategory.BOOKS,
            stock = 10
        )
    )
    productService.createProduct(
        CreateProductRequest(
            name = "청바지",
            price = 40000,
            category = ProductCategory.FASHION,
            stock = 10
        )
    )
}