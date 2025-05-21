package com.example.demo.product.service

import annotation.Contract4kWith
import com.example.demo.global.findByIdOrThrow
import com.example.demo.product.contract.BuyProductContract
import com.example.demo.product.contract.BuyProductSoftContract
import com.example.demo.product.domain.Product
import com.example.demo.product.domain.ProductRepository
import com.example.demo.product.service.dto.request.CreateProductRequest
import com.example.demo.product.service.dto.response.ProductResponse
import com.example.demo.product.service.dto.response.toResponse

class ProductService(
    private val productRepository: ProductRepository,
) {

    fun createProduct(request: CreateProductRequest): ProductResponse {
        val product: Product = productRepository.save(request.toProduct())
        return ProductResponse.of(product)
    }

    fun getProduct(id: Long): ProductResponse {
        val product: Product = productRepository.findByIdOrThrow(id) { "Product with id: $id not found" }
        return ProductResponse.of(product)
    }

    fun getProducts(): List<ProductResponse> {
        return productRepository.findAll().map { ProductResponse.of(it) }
    }

    fun deleteProduct(id: Long) {
        val product = productRepository.findByIdOrThrow(id) { "Product with id: $id not found" }
        productRepository.deleteById(product.id)
    }

    fun clear(){
        productRepository.clear()
    }

    fun buyProduct1(id: Long, stock: Int, price: Int): ProductResponse{
        // 사전 조건
        require(stock in 1..100) { "구매 개수는 1이상 100이하여야 합니다." }
        require(price > 0) { "가격은 양수여야 합니다." }

        val product = productRepository.findByIdOrThrow(id) { "Product with id: $id not found" }
        product.deductStock(stock)
        val productResponse = product.toResponse()

        // 사후 조건
        require(productResponse.stock >= 0) { "남은 재고는 0이상 이여야 합니다." }
        require(productResponse.price > 0) { "가격은 양수여야 합니다." }

        return productResponse
    }

    @Contract4kWith(BuyProductContract::class)
    fun buyProduct2(id: Long, stock: Int, price: Int): ProductResponse{

        val product = productRepository.findByIdOrThrow(id) { "Product with id: $id not found" }
        product.deductStock(stock)
        val productResponse = product.toResponse()

        return productResponse
    }

    // TODO softConditions인 경우 에러 로그가 안뜸
    @Contract4kWith(BuyProductSoftContract::class)
    fun buyProduct3(id: Long, stock: Int, price: Int): ProductResponse{

        val product = productRepository.findByIdOrThrow(id) { "Product with id: $id not found" }
        product.deductStock(stock)
        val productResponse = product.toResponse()

        return productResponse
    }
}