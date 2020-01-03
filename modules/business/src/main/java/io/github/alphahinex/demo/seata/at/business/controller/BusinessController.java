package io.github.alphahinex.demo.seata.at.business.controller;

import io.github.alphahinex.demo.seata.at.business.service.BusinessService;
import io.github.alphahinex.demo.seata.at.business.vo.BusinessVO;
import io.github.springroll.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/at/business")
public class BusinessController extends BaseController {

    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping("/buy")
    public ResponseEntity buy(@RequestBody BusinessVO vo) {
        return businessService.handleBusiness(vo);
    }

}
