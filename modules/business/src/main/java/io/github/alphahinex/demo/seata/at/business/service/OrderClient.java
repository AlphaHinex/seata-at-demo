package io.github.alphahinex.demo.seata.at.business.service;

import io.github.alphahinex.demo.seata.at.business.service.model.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order", path = "/at/order")
public interface OrderClient {

    @PostMapping
    ResponseEntity<OrderVO> createOrder(@RequestBody OrderVO vo);

}
