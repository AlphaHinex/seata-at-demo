package io.github.alphahinex.demo.seata.at.account.service;

import io.github.alphahinex.demo.seata.at.account.entity.AccountEntity;
import io.github.alphahinex.demo.seata.at.account.repository.AccountRepository;
import io.github.alphahinex.demo.seata.at.account.vo.AccountVO;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {

    private AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Double decrease(AccountVO vo) {
        log.debug("Global transaction id: {}", RootContext.getXID());
        AccountEntity entity = repository.findByUserId(vo.getUserId());
        entity.setAmount(entity.getAmount() - vo.getAmount().doubleValue());
        repository.save(entity);
        return entity.getAmount();
    }

}
