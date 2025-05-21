package com.example.demo.product.service

import annotation.Contract4kWith
import com.example.demo.global.findByIdOrThrow
import com.example.demo.product.contract.BuyProductContract
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

    fun getCustomers(): List<ProductResponse> {
        return productRepository.findAll().map { ProductResponse.of(it) }
    }

    fun deleteCustomer(id: Long) {
        val product = productRepository.findByIdOrThrow(id) { "Product with id: $id not found" }
        productRepository.deleteById(product.id)
    }

    fun clear(){
        productRepository.clear()
    }

    fun buyProduct1(id: Long, stock: Int): ProductResponse{
        require(stock > 0) { "Product stock must be greater than 0" }

        val product = productRepository.findByIdOrThrow(id) { "Product with id: $id not found" }
        product.deductStock1(stock)
        val productResponse = product.toResponse()

        require(productResponse.stock >= 0) { "Product stock must be greater than 0" }
        return productResponse
    }

    @Contract4kWith(BuyProductContract::class)
    fun buyProduct2(id: Long, stock: Int): ProductResponse{
        require(stock > 0) { "Product stock must be greater than 0" }

        val product = productRepository.findByIdOrThrow(id) { "Product with id: $id not found" }
        product.deductStock1(stock)
        val productResponse = product.toResponse()

        require(productResponse.stock >= 0) { "Product stock must be greater than 0" }
        return productResponse
    }
}