package io.github.alphahinex.demo.seata.at.storage

import groovy.json.JsonOutput
import io.github.alphahinex.demo.seata.at.storage.vo.CommodityVO
import io.github.springroll.test.AbstractSpringTest
import org.junit.Test
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional

@Sql
@Transactional
class StorageApplicationTest extends AbstractSpringTest {

    @Test
    void testDecrease() {
        def sum = 100
        def decrease = 2
        def left = sum - decrease

        String code = "test"
        def res = resOfGet("/at/storage/" + code, HttpStatus.OK)
        assert res.count == sum

        def vo = new CommodityVO()
        vo.setCount(decrease)
        vo.setCommodityCode(code)
        res = resOfPut("/at/storage/decrease", JsonOutput.toJson(vo), HttpStatus.OK)
        assert res == left

        assert resOfGet("/at/storage/" + code, HttpStatus.OK).count == left
    }

}
