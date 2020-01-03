package io.github.alphahinex.demo.seata.at.order

import io.github.alphahinex.demo.seata.at.order.service.StorageClient
import io.github.springroll.test.AbstractSpringTest
import org.junit.Test
import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class OrderControllerTest extends AbstractSpringTest {

    @MockBean
    private StorageClient storageClient

    @Test
    void testGetStorage() {
        def code = '123'
        Mockito.when(storageClient.get(code)).thenReturn(new ResponseEntity([code: code, type: 'mock'], HttpStatus.OK))
        assert resOfGet("/at/order/storage/$code", HttpStatus.OK).type == 'mock'
    }

}
