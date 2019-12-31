package io.github.alphahinex.demo.seata.at.storage.repository;

import io.github.alphahinex.demo.seata.at.common.repository.BaseRepository;
import io.github.alphahinex.demo.seata.at.storage.entity.StorageEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StorageRepository extends BaseRepository<StorageEntity, String> {

    @Modifying
    @Query(value = "UPDATE t_storage SET count = count - :count WHERE commodity_code = :commodityCode", nativeQuery = true)
    Integer decrease(@Param("count") Integer count, @Param("commodityCode") String commodityCode);

}
