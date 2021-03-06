package io.github.alphahinex.demo.seata.at.storage.controller;

import io.github.alphahinex.demo.seata.at.storage.service.StorageService;
import io.github.alphahinex.demo.seata.at.storage.vo.CommodityVO;
import io.github.springroll.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/at/storage")
public class StorageController extends BaseController {

    private StorageService service;

    @Autowired
    public StorageController(StorageService service) {
        this.service = service;
    }

    @PutMapping("/decrease")
    ResponseEntity<Integer> decrease(@RequestBody CommodityVO vo) {
        return responseOfPut(service.decrease(vo));
    }

    @GetMapping("/{code}")
    ResponseEntity<CommodityVO> get(@PathVariable String code) {
        return responseOfGet(service.findByCode(code));
    }

}
