package com.example.demo.product.service.dto.response

import com.example.demo.product.domain.Product
import com.example.demo.product.domain.ProductCategory
import com.example.demo.product.domain.ProductStatus

data class ProductResponse(
    val name: String,
    val price: Int,
    val stock: Int,
    val category: ProductCategory,
    val status: ProductStatus,
    val id: Long
) {
    companion object {
        fun of(product: Product): ProductResponse {
            return ProductResponse(
                product.name,
                product.price,
                product.stock,
                product.category,
                product.status,
                product.id
            )
        }
    }
}

fun Product.toResponse(): ProductResponse = ProductResponse(name, price, stock, category, status, id)