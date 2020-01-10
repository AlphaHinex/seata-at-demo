package io.github.alphahinex.demo.seata.at.integration.test

import io.github.springroll.test.AbstractIntegrationTest
import org.junit.Test
import org.springframework.http.HttpStatus

class IntegrationTest extends AbstractIntegrationTest {

    @Test
    void test() {
        get('http://www.baidu.com', HttpStatus.OK)
    }

}
