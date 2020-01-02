package io.github.alphahinex.demo.seata.at.account.repository;

import io.github.alphahinex.demo.seata.at.account.entity.AccountEntity;
import io.github.alphahinex.demo.seata.at.common.repository.BaseRepository;

public interface AccountRepository extends BaseRepository<AccountEntity, String> {

    AccountEntity findByUserId(String userId);

}
