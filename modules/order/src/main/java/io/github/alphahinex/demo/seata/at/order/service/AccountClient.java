package io.github.alphahinex.demo.seata.at.order.service;

import io.github.alphahinex.demo.seata.at.order.service.model.AccountVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account", path = "/at/account")
public interface AccountClient {

    @PutMapping("/decrease")
    ResponseEntity<Double> decrease(@RequestBody AccountVO vo);

}
