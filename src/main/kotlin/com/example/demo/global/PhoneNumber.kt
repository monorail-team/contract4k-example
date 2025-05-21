package com.example.demo.global

@JvmInline
value class PhoneNumber(
    val value: String
) {

    init {
        invariant()
    }

    private fun invariant(){
        require(value.matches(Regex("^01[0-9]-\\d{3,4}-\\d{4}$"))) {
            "전화번호 형식이 올바르지 않습니다. 예: 010-1234-5678"
        }
    }

    override fun toString(): String = value
}
