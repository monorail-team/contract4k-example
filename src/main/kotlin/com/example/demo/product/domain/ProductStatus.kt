package com.example.demo.product.domain

enum class ProductStatus(
    val code: String,
    val message: String
) {

    AVAILABLE("AVAILABLE", "판매 중"),
    SOLD_OUT("SOLD_OUT", "품절"),
    DISCONTINUED("DISCONTINUED", "판매 중단");

    companion object {
        fun from(code: String): ProductStatus =
            entries.find { it.code == code }
                ?: throw IllegalArgumentException("${code}에 해당하는 ProductStatus가 없습니다.")
    }
}

