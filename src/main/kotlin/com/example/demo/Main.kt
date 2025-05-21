package com.example.demo

import com.example.demo.customer.domain.CustomerRepository
import com.example.demo.customer.service.CustomerService
import com.example.demo.customer.service.dto.request.CreatCustomerRequest
import com.example.demo.global.Email
import com.example.demo.global.PhoneNumber
import com.example.demo.product.domain.ProductCategory
import com.example.demo.product.domain.ProductRepository
import com.example.demo.product.service.ProductService
import com.example.demo.product.service.dto.request.CreateProductRequest
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val productRepository = ProductRepository()
    val productService = ProductService(productRepository)

    init()

    val br = BufferedReader(InputStreamReader(System.`in`))
    loop@ while (true) {
        println(
            """
            ╔══════════════════ Menu ═══════════════════╗
            1. 기존 메서드 - 성공 케이스
            2. Contract4k - 성공 케이스
            3. Contract4k SoftConditions - 성공 케이스
            4. 기존 메서드 - 실패 케이스
            5. Contract4k - 실패 케이스
            6. Contract4k SoftConditions - 실패 케이스
            7. 모든 상품 조회
            q. 종료
            ╚═══════════════════════════════════════════╝
            입력 > """.trimIndent()
        )

        when (val cmd = br.readLine().trim()) {
            "1" -> {
                method1(productService)
            }

            "2" -> {
                method2(productService)
            }

            "3" -> {
                method3(productService)
            }

            "4" -> {
                method4(productService)
            }

            "5" -> {
                method5(productService)
            }

            "6" -> {
                method6(productService)
            }

            "7" -> {
                method7(productService)
            }

            "q", "Q" -> {
                println("프로그램을 종료합니다.")
                break@loop
            }

            else -> println("잘못된 입력입니다.\n")
        }
    }
}

private fun method1(productService: ProductService) {
    println(
        """
                    =============================================
                    
                    ╔════════════════ Parameter ════════════════╗
                    id: 1
                    stock: 10
                    price: 4000
                    ╚═══════════════════════════════════════════╝
                    buyProduct1 호출""".trimIndent()
    )
    val response = productService.buyProduct1(1L, 10, 4000)
    println(
        """
                    ╔═══════════════════ 결과 ═══════════════════╗
                    id: ${response.id}
                    stock: ${response.stock}
                    price: ${response.price}
                    ╚═══════════════════════════════════════════╝
                    
                    =============================================
                    """.trimIndent()
    )
}

private fun method2(productService: ProductService) {
    println(
        """
                    =============================================
                    
                    ╔════════════════ Parameter ════════════════╗
                    id: 1
                    stock: 10
                    price: 4000
                    ╚═══════════════════════════════════════════╝
                    buyProduct2 호출""".trimIndent()
    )
    val response = productService.buyProduct2(1L, 10, 4000)
    println(
        """
                    ╔═══════════════════ 결과 ═══════════════════╗
                    id: ${response.id}
                    stock: ${response.stock}
                    price: ${response.price}
                    ╚═══════════════════════════════════════════╝
                    
                    =============================================
                    """.trimIndent()
    )
}

private fun method3(productService: ProductService) {
    println(
        """
                    =============================================
                    
                    ╔════════════════ Parameter ════════════════╗
                    id: 1
                    stock: 10
                    price: 4000
                    ╚═══════════════════════════════════════════╝
                    buyProduct3 호출""".trimIndent()
    )
    val response = productService.buyProduct3(1L, 10, 4000)
    println(
        """
                    ╔═══════════════════ 결과 ═══════════════════╗
                    id: ${response.id}
                    stock: ${response.stock}
                    price: ${response.price}
                    ╚═══════════════════════════════════════════╝
                    
                    =============================================
                    """.trimIndent()
    )
}

private fun method4(productService: ProductService) {
    println(
        """
                    =============================================
                    
                    ╔════════════════ Parameter ════════════════╗
                    id: 1
                    stock: 0
                    price: -1
                    ╚═══════════════════════════════════════════╝
                    buyProduct1 호출
                    
                    =============================================
                    """.trimIndent()
    )
    val response = productService.buyProduct1(1L, 0, -1)
}

private fun method5(productService: ProductService) {
    println(
        """
                    =============================================
                    
                    ╔════════════════ Parameter ════════════════╗
                    id: 1
                    stock: -10
                    price: -1
                    ╚═══════════════════════════════════════════╝
                    buyProduct2 호출
                    
                    =============================================
                    """.trimIndent()
    )
    val response = productService.buyProduct2(1L, -10, -1)
}

private fun method6(productService: ProductService) {
    println(
        """
                    =============================================
                    
                    ╔════════════════ Parameter ════════════════╗
                    id: 1
                    stock: 10
                    price: -1
                    ╚═══════════════════════════════════════════╝
                    buyProduct3 호출
                    
                    =============================================
                    """.trimIndent()
    )
    val response = productService.buyProduct3(1L, 10, -100)
}

private fun method7(productService: ProductService) {
    val products = productService.getProducts()
    if (products.isEmpty()) {
        println("등록된 상품이 없습니다.\n")
    } else {
        println("=============================================")
        println()
        println("╔═══════════════ 전체 상품 목록 ═══════════════╗")
        products.forEach { product ->
            println(
                """
                id      : ${product.id}
                name    : ${product.name}
                price   : ${product.price}
                stock   : ${product.stock}
                category: ${product.category}
                status  : ${product.status}
                """.trimIndent()
            )
        }
        println("╚═══════════════════════════════════════════╝\n")
        println()
        println("=============================================")
    }
}

fun init() {
    val customerRepository = CustomerRepository()
    val productRepository = ProductRepository()

    val customerService = CustomerService(customerRepository)
    val productService = ProductService(productRepository)

    customerService.createCustomer(
        CreatCustomerRequest(
            name = "김싸피",
            email = Email("ssafy1@ssafy.com"),
            phoneNumber = PhoneNumber("010-1234-1111"),
            address = "서울특별시 강남구 테헤란로 212",
            zipCode = "06220"
        )
    )
    customerService.createCustomer(
        CreatCustomerRequest(
            name = "이싸피",
            email = Email("ssafy2@ssafy.com"),
            phoneNumber = PhoneNumber("010-1234-2222"),
            address = "서울특별시 강남구 테헤란로 212",
            zipCode = "06220"
        )
    )
    customerService.createCustomer(
        CreatCustomerRequest(
            name = "최싸피",
            email = Email("ssafy3@ssafy.com"),
            phoneNumber = PhoneNumber("010-1234-3333"),
            address = "서울특별시 강남구 테헤란로 212",
            zipCode = "06220"
        )
    )

    productService.createProduct(
        CreateProductRequest(
            name = "김밥",
            price = 4000,
            category = ProductCategory.FOOD,
            stock = 30
        )
    )
}