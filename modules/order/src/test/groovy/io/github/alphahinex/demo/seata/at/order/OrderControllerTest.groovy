package io.github.alphahinex.demo.seata.at.order

import feign.Client
import feign.Request
import feign.Response
import io.github.springroll.test.AbstractSpringTest
import org.junit.Test

class OrderControllerTest extends AbstractSpringTest {

    @Test
    void test() {
        println System.getProperty('http.proxyHost')
        println System.getProperty('http.nonProxyHosts')
        println System.getProperty('https.nonProxyHosts')
        def url = 'http://10.88.43.229:8081/at/storage/123'
//        def url = 'https://github.com'
        def client = new Client.Default(null, null)
        def request = new Request(Request.HttpMethod.GET, url, [:], new Request.Body(null, null, null))
        def option = new Request.Options(1000, 1000, true)
        Response response = client.execute(request, option)
        assert response.status() != 407
    }

}
