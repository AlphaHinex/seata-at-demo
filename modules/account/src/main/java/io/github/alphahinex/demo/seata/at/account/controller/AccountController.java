package io.github.alphahinex.demo.seata.at.account.controller;

import io.github.alphahinex.demo.seata.at.account.service.AccountService;
import io.github.alphahinex.demo.seata.at.account.vo.AccountVO;
import io.github.springroll.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/at/account")
public class AccountController extends BaseController {

    private AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @PutMapping("/decrease")
    ResponseEntity<Double> decrease(@RequestBody AccountVO vo) {
        return responseOfPut(service.decrease(vo));
    }

}
