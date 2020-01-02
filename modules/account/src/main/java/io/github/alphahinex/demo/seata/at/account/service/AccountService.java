package io.github.alphahinex.demo.seata.at.account.service;

import io.github.alphahinex.demo.seata.at.account.entity.AccountEntity;
import io.github.alphahinex.demo.seata.at.account.repository.AccountRepository;
import io.github.alphahinex.demo.seata.at.account.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Double decrease(AccountVO vo) {
        AccountEntity entity = repository.findByUserId(vo.getUserId());
        entity.setAmount(entity.getAmount() - vo.getAmount().doubleValue());
        repository.save(entity);
        return entity.getAmount();
    }

}
