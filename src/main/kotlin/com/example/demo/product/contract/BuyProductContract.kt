package com.example.demo.product.contract

import com.example.demo.product.service.dto.response.ProductResponse
import condition.util.*
import contract.Contract4KDsl
import contract.conditions

object BuyProductContract: Contract4KDsl<Pair<Long, Int>, ProductResponse> {
    override fun validateInvariant(input: Pair<Long, Int>, output: ProductResponse) {
        val (id, inputStock) = input
        val outputStock = output.stock


    }

    override fun validatePre(input: Pair<Long, Int>) {
        val (id, stock) = input

        conditions {
            "id는 null이 될 수 없습니다" means { id isNot nil }
            "구매 개수는 null이 될 수 없습니다" means { stock isNot nil }
            "구매 개수는 1이상 100이하 입니다." means { stock between 1..100}
        }
    }

    override fun validatePost(input: Pair<Long, Int>, result: ProductResponse) {
        val ouputStock = result.stock
        conditions {
            "남은 재고 수량은 양수여야 합니다." means { ouputStock `is` positive}
        }
    }
}