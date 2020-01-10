package io.github.alphahinex.demo.seata.at.integration.test

import groovy.json.JsonOutput
import io.github.springroll.test.AbstractIntegrationTest
import org.junit.Test
import org.springframework.http.HttpStatus

/**
 * 下订单操作服务调用顺序：
 * 1. 减库存
 * 2. 创建订单
 *  2.1. 扣减用户账户
 *  2.2. 生成订单
 */
class IntegrationTest extends AbstractIntegrationTest {

    def count = 2
    def commodityCode = 'C201901140001'
    def url = 'http://localhost:8084/at/business/buy'
    def vo = ["userId":"1","commodityCode":commodityCode,"name":"水杯","count":count]

    @Test
    void successRequest() {
        vo.put('amount', 100)
        post(url, JsonOutput.toJson(vo), HttpStatus.CREATED)
    }

    @Test
    void failedRequest() {
        def storage = resOfGet("http://localhost:8081/at/storage/$commodityCode", HttpStatus.OK).count

        // 生成订单服务抛出异常
        vo.put('amount', -10)
        post(url, JsonOutput.toJson(vo), HttpStatus.INTERNAL_SERVER_ERROR)

        // 库存已减
        def newStorage = resOfGet("http://localhost:8081/at/storage/$commodityCode", HttpStatus.OK).count
        assert newStorage == storage - count
    }

}
