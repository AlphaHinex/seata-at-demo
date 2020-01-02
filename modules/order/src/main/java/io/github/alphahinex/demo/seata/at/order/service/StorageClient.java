package io.github.alphahinex.demo.seata.at.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("storage")
public interface StorageClient {

    @GetMapping("/at/storage/{code}")
    ResponseEntity get(@PathVariable("code") String code);

}
