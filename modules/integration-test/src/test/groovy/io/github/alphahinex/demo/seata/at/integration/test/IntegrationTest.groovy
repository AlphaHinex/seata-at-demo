package io.github.alphahinex.demo.seata.at.integration.test

import groovy.json.JsonOutput
import io.github.springroll.test.AbstractIntegrationTest
import org.junit.Test
import org.springframework.http.HttpStatus

class IntegrationTest extends AbstractIntegrationTest {

    def url = 'http://localhost:8084/at/business/buy'
    def vo = ["userId":"1","commodityCode":"C201901140001","name":"水杯","count":2]

    @Test
    void successRequest() {
        vo.put('amount', 100)
        post(url, JsonOutput.toJson(vo), HttpStatus.CREATED)
    }

    @Test
    void failedRequest() {
        vo.put('amount', -10)
        post(url, JsonOutput.toJson(vo), HttpStatus.INTERNAL_SERVER_ERROR)
    }

}
