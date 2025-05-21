package com.example.demo.customer.service

import com.example.demo.customer.domain.Customer
import com.example.demo.customer.domain.CustomerRepository
import com.example.demo.customer.service.dto.request.CreatCustomerRequest
import com.example.demo.customer.service.dto.response.CustomerResponse
import com.example.demo.global.findByIdOrThrow

class CustomerService(
    private val customerRepository: CustomerRepository
) {

    fun createCustomer(creatCustomerRequest: CreatCustomerRequest): CustomerResponse {
        val customer: Customer = customerRepository.save(creatCustomerRequest.toCustomer())
        return CustomerResponse.of(customer)
    }

    fun getCustomer(id: Long): CustomerResponse {
        val customer: Customer = customerRepository.findByIdOrThrow(id) { "Customer with id: $id not found" }
        return CustomerResponse.of(customer)
    }

    fun getCustomers(): List<CustomerResponse> {
        return customerRepository.findAll().map { CustomerResponse.of(it) }
    }

    fun deleteCustomer(id: Long) {
        val customer = customerRepository.findByIdOrThrow(id) { "Customer with id: $id not found" }
        customerRepository.deleteById(customer.id)
    }

    fun clear(){
        customerRepository.clear()
    }
}
