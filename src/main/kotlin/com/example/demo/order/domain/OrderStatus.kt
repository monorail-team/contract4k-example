package com.example.demo.order.domain

enum class OrderStatus(
    val code: String,
    val message: String,
) {
    CREATED("CREATED", "주문 생성됨"),
    CONFIRMED("CONFIRMED", "주문 확정"),
    CANCELED("CANCELED", "주문 취소됨"),
    EXPIRED("EXPIRED", "주문 유효기간 만료");

    companion object {
        fun from(code: String): OrderStatus =
            entries.find { it.code == code }
                ?: throw IllegalArgumentException("${code}에 해당하는 OrderStatus가 존재하지 않습니다.")
    }
}
