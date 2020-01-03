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
        Mockito.when(storageClient.get('123')).thenReturn(new ResponseEntity([], HttpStatus.OK))
        get('/at/order/storage/123', HttpStatus.OK)
    }

}
