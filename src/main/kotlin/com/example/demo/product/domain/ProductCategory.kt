package com.example.demo.product.domain

enum class ProductCategory(
    val code: String,
    val message: String,
) {
    FOOD("FOOD", "음식"),
    FASHION("FASHION", "패션"),
    BEAUTY("BEAUTY", "뷰티/화장품"),
    ELECTRONICS("ELECTRONICS", "전자제품"),
    BOOKS("BOOKS", "도서"),
    TOYS("TOYS", "완구/취미"),
    SPORTS("SPORTS", "스포츠/레저"),
    LIVING("LIVING", "생활용품"),
    HEALTH("HEALTH", "건강식품/기기"),
    PET("PET", "반려동물용품"),
    ETC("ETC", "기타");

    companion object {
        fun from(code: String): ProductCategory =
            entries.find { it.code == code }
                ?: throw IllegalArgumentException("Unknown category code: $code")
    }
}