package io.github.alphahinex.demo.seata.at.storage.controller;

import io.github.alphahinex.demo.seata.at.common.controller.BaseController;
import io.github.alphahinex.demo.seata.at.storage.service.StorageService;
import io.github.alphahinex.demo.seata.at.storage.vo.CommodityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/at/storage")
public class StorageController extends BaseController {

    private StorageService service;

    @Autowired
    public StorageController(StorageService service) {
        this.service = service;
    }

    @PostMapping("/decrease")
    ResponseEntity<Integer> decrease(@RequestBody CommodityVO vo) {
        return responseOfPost(service.decrease(vo));
    }

}
