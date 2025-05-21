package com.example.demo.product.contract

import com.example.demo.product.service.dto.response.ProductResponse
import condition.util.between
import condition.util.`is`
import condition.util.positive
import contract.Contract4KDsl
import contract.softConditions

object BuyProductSoftContract : Contract4KDsl<Triple<Long, Int, Int>, ProductResponse> {
    override fun validatePre(input: Triple<Long, Int, Int>) {
        val (id, stock, price) = input

        softConditions {
            "구매 개수는 1이상 100이하여야 합니다." means { stock between 1..100}
            "가격은 양수여야 합니다." means { price `is` positive }
        }
    }

    override fun validatePost(input: Triple<Long, Int, Int>, result: ProductResponse) {
        val stock = result.stock
        val price = result.price

        softConditions {
            "남은 재고는 0이상여야 합니다." means { stock >= 0 }
            "가격은 양수여야 합니다." means { price `is` positive }
        }
    }
}