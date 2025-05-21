package com.example.demo.product.contract

import contract.Contract4KDsl

object StockContract: Contract4KDsl<Int, Int> {
    override fun validateInvariant(input: Int, output: Int) {
        super.validateInvariant(input, output)
    }

    override fun validatePre(input: Int) {
        super.validatePre(input)
    }

    override fun validatePost(input: Int, result: Int) {
        super.validatePost(input, result)
    }
}