package io.github.alphahinex.demo.seata.at.account.repository;

import io.github.alphahinex.demo.seata.at.account.entity.AccountEntity;
import io.github.springroll.base.jpa.BaseRepository;

public interface AccountRepository extends BaseRepository<AccountEntity, String> {

    AccountEntity findByUserId(String userId);

}
