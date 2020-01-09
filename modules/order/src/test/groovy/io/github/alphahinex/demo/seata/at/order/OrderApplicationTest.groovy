package io.github.alphahinex.demo.seata.at.order

import groovy.json.JsonOutput
import io.github.alphahinex.demo.seata.at.order.service.AccountClient
import io.github.alphahinex.demo.seata.at.order.service.StorageClient
import io.github.alphahinex.demo.seata.at.order.service.model.AccountVO
import io.github.springroll.test.AbstractSpringTest
import org.junit.Test
import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class OrderApplicationTest extends AbstractSpringTest {

    def prefix = '/at/order'

    @MockBean
    private StorageClient storageClient

    @MockBean
    private AccountClient accountClient

    @Test
    void testGetStorage() {
        def code = '123'
        Mockito.when(storageClient.get(code)).thenReturn(new ResponseEntity([code: code, type: 'mock'], HttpStatus.OK))
        assert resOfGet("$prefix/storage/$code", HttpStatus.OK).type == 'mock'
    }

    @Test
    void testCreateOrder() {
        def userId = 'mock-user'
        def orderAmount = BigDecimal.TEN
        def vo = new AccountVO()
        vo.setUserId(userId)
        vo.setAmount(orderAmount)
        Mockito.when(accountClient.decrease(vo)).thenReturn(new ResponseEntity<Double>(100d, HttpStatus.OK))
        def res = resOfPost(prefix, JsonOutput.toJson([userId: userId, orderAmount: orderAmount, orderCount: 23]), HttpStatus.CREATED)
        assert res.id != ''
        assert res.orderNo != ''
    }

}
