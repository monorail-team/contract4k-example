package com.example.demo.customer.service.dto.response

import com.example.demo.customer.domain.Customer
import com.example.demo.global.Email
import com.example.demo.global.PhoneNumber

data class CustomerResponse(
    val name: String,
    val email: Email,
    val phoneNumber: PhoneNumber,
    val address: String,
    val zipCode: String,
    val id: Long,
) {

    companion object {
        fun of(customer: Customer): CustomerResponse {
            return CustomerResponse(
                customer.name,
                customer.email,
                customer.phoneNumber,
                customer.address,
                customer.zipCode,
                customer.id
            )
        }
    }
}