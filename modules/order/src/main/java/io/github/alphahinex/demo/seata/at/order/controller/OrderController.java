package io.github.alphahinex.demo.seata.at.order.controller;

import io.github.alphahinex.demo.seata.at.order.service.OrderService;
import io.github.alphahinex.demo.seata.at.order.service.StorageClient;
import io.github.alphahinex.demo.seata.at.order.vo.OrderVO;
import io.github.springroll.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/at/order")
public class OrderController extends BaseController {

    private OrderService service;
    private StorageClient storageClient;

    @Autowired
    public OrderController(OrderService service, StorageClient storageClient) {
        this.service = service;
        this.storageClient = storageClient;
    }

    @PostMapping
    ResponseEntity<OrderVO> createOrder(@RequestBody OrderVO vo) {
        return responseOfPost(service.createOrder(vo));
    }

    @GetMapping("/storage/{code}")
    ResponseEntity getStorage(@PathVariable String code) {
        return responseOfGet(storageClient.get(code).getBody());
    }

}
