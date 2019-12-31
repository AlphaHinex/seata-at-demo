package io.github.alphahinex.demo.seata.at.storage.repository;

import io.github.alphahinex.demo.seata.at.common.repository.BaseRepository;
import io.github.alphahinex.demo.seata.at.storage.entity.StorageEntity;

public interface StorageRepository extends BaseRepository<StorageEntity, String> {

    StorageEntity findByCommodityCode(String commodityCode);

}
