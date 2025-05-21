package com.example.demo.global

@JvmInline
value class Email(
    val value: String
){

    init {
        invariant()
    }

    private fun invariant() {
        require(value.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))) {
            "유효하지 않은 이메일 형식입니다: $value"
        }
        require(value.length <= 50) { "Email은 50자 이하입니다." }
    }

    override fun toString(): String = value
}
