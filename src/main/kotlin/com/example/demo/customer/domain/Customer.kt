package com.example.demo.customer.domain

import com.example.demo.global.*
import java.util.concurrent.atomic.AtomicLong

class Customer(
    var name: String,
    var email: Email,
    var phoneNumber: PhoneNumber,
    var address: String,
    var zipCode: String,
    val id: Long = nextId()
) {

    init {
        validate()
    }

    companion object {
        private val idSequence = AtomicLong(1L)

        fun nextId(): Long = idSequence.getAndIncrement()

        fun of(name: String, email: Email, phoneNumber: PhoneNumber, address: String, zipCode: String): Customer {
            return Customer(
                name,
                email,
                phoneNumber,
                address,
                zipCode
            )
        }
    }

    private fun validate() {
        validateName(name)
        validateAddress(address)
        validateZipCode(zipCode)
    }

    fun changeName(name: String) {
        validateName(name)
        this.name = name
    }

    fun changeEmail(email: Email) {
        this.email = email
    }

    fun changePhoneNumber(phoneNumber: PhoneNumber) {
        this.phoneNumber = phoneNumber
    }

    fun changeAddress(address: String) {
        validateAddress(address)
        this.address = address
    }

    fun changeZipCode(zipCode: String) {
        validateZipCode(zipCode)
        this.zipCode = zipCode
    }

    private fun validateName(name: String) {
        require(name.length in 2..20) { "이름은 2자 이상 20자 이하여야 합니다." }
    }

    private fun validateAddress(address: String) {
        require(address.isNotBlank()) { "주소는 비어 있을 수 없습니다." }
    }

    private fun validateZipCode(zipCode: String) {
        require(zipCode.matches(Regex("^\\d{5}$"))) { "우편번호는 5자리 숫자여야 합니다." }
    }
}

