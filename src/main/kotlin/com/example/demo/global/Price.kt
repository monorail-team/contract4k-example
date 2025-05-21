package com.example.demo.global

@JvmInline
value class Price(
    val value: Int
) {

    init {
        require(value >= 0) { "가격은 0 이상이어야 합니다." }
    }

    operator fun plus(price: Price): Price = Price(value + price.value)
    operator fun minus(price: Price): Price = Price(value - price.value)

    fun isGreaterThanOrEqual(other: Price): Boolean = this.value >= other.value

    override fun toString(): String = value.toString()
}
