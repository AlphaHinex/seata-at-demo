package io.github.alphahinex.demo.seata.at.storage.repository;

import io.github.alphahinex.demo.seata.at.common.repository.BaseRepository;
import io.github.alphahinex.demo.seata.at.storage.entity.StorageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StorageRepository extends BaseRepository<StorageEntity, String> {

    @Query("UPDATE StorageEntity SET count = count-:count WHERE commodityCode = :commodityCode")
    Integer decrease(@Param("count") Integer count, @Param("commodityCode") String commodityCode);

}
