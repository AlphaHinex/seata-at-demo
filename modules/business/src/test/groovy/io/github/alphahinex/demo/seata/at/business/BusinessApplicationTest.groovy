package io.github.alphahinex.demo.seata.at.business

import groovy.json.JsonOutput
import io.github.alphahinex.demo.seata.at.business.service.OrderClient
import io.github.alphahinex.demo.seata.at.business.service.StorageClient
import io.github.alphahinex.demo.seata.at.business.service.model.OrderVO
import io.github.springroll.test.AbstractSpringTest
import org.junit.Test
import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class BusinessApplicationTest extends AbstractSpringTest {

    @MockBean
    private StorageClient storageClient
    @MockBean
    private OrderClient orderClient

    @Test
    void testBuy() {
        Mockito.when(orderClient.createOrder(new OrderVO())).thenReturn(new ResponseEntity<OrderVO>(HttpStatus.CREATED))
        post('/at/business/buy', JsonOutput.toJson([:]), HttpStatus.CREATED)
    }

}
