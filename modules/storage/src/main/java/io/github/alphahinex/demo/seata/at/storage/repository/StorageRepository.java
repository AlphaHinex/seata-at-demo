package io.github.alphahinex.demo.seata.at.storage.repository;

import io.github.alphahinex.demo.seata.at.storage.entity.StorageEntity;
import io.github.springroll.base.jpa.BaseRepository;

public interface StorageRepository extends BaseRepository<StorageEntity, String> {

    StorageEntity findByCommodityCode(String commodityCode);

}
