package com.example.demo.customer.service.dto.request

import com.example.demo.customer.domain.Customer
import com.example.demo.global.Email
import com.example.demo.global.PhoneNumber

data class CreatCustomerRequest(
    val name: String,
    val email: Email,
    val phoneNumber: PhoneNumber,
    val address: String,
    val zipCode: String,
) {

    fun toCustomer(): Customer = Customer.of(name, email, phoneNumber, address, zipCode)
}