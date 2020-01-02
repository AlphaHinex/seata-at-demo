package io.github.alphahinex.demo.seata.at.account

import groovy.json.JsonOutput
import io.github.alphahinex.demo.seata.at.account.vo.AccountVO
import io.github.springroll.test.AbstractSpringTest
import org.junit.Test
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional

@Sql
@Transactional
class AccountApplicationTest extends AbstractSpringTest {

    @Test
    void testDecrease() {
        def sum = 100
        def decrease = BigDecimal.valueOf(2)
        def left = sum - decrease

        def userId = "test-user"
        def vo = new AccountVO()
        vo.setAmount(decrease)
        vo.setUserId(userId)
        def res = resOfPut("/at/account/decrease", JsonOutput.toJson(vo), HttpStatus.OK)
        assert res == left
    }

}
