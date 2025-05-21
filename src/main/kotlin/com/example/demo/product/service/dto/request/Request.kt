package com.example.demo.product.service.dto.request

import com.example.demo.global.Price
import com.example.demo.global.Quantity
import com.example.demo.product.domain.Product
import com.example.demo.product.domain.ProductCategory

data class CreateProductRequest(
    val name: String,
    val price: Int,
    val stock: Int,
    val category: ProductCategory,
) {

    fun toProduct(): Product = Product.of(name, price, stock, category)
}

data class UpdateProductRequest(
    val name: String,
    val price: Price,
    val stock: Quantity,
    val category: ProductCategory,
)