package io.github.alphahinex.demo.seata.at.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "account", path = "/at/account")
public interface AccountClient {

    @PutMapping("/decrease")
    ResponseEntity<Double> decrease(@RequestParam("userId") String userId, @RequestParam("amount") BigDecimal amount);

}
