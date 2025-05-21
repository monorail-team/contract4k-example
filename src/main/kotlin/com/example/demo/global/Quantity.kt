package com.example.demo.global

@JvmInline
value class Quantity(val value: Int) {

    init {
        require(value in 0..100) { "수량은 0이상 100이하 입니다." }
    }

    operator fun plus(other: Quantity): Quantity = Quantity(this.value + other.value)
    operator fun minus(other: Quantity): Quantity = Quantity(this.value - other.value)

    fun isGreaterThanOrEqual(other: Quantity): Boolean = this.value >= other.value
    fun isZero(): Boolean = this.value == 0
    fun isPositive(): Boolean = this.value > 0

    override fun toString(): String = value.toString()
}
