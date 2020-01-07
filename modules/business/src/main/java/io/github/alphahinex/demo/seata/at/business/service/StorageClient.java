package io.github.alphahinex.demo.seata.at.business.service;

import io.github.alphahinex.demo.seata.at.business.service.model.CommodityVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "storage", path = "/at/storage")
public interface StorageClient {

    @PutMapping("/decrease")
    ResponseEntity<Integer> decrease(@RequestBody CommodityVO vo);

}
