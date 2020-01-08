package io.github.alphahinex.demo.seata.at.storage.service;

import io.github.alphahinex.demo.seata.at.storage.entity.StorageEntity;
import io.github.alphahinex.demo.seata.at.storage.repository.StorageRepository;
import io.github.alphahinex.demo.seata.at.storage.vo.CommodityVO;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageService {

    private StorageRepository repository;

    @Autowired
    public StorageService(StorageRepository repository) {
        this.repository = repository;
    }

    public Integer decrease(CommodityVO vo) {
        log.debug("Global transaction id: {}", RootContext.getXID());
        StorageEntity entity = repository.findByCommodityCode(vo.getCommodityCode());
        entity.setCount(entity.getCount() - vo.getCount());
        repository.save(entity);
        return entity.getCount();
    }

    public CommodityVO findByCode(String code) {
        StorageEntity entity = repository.findByCommodityCode(code);
        CommodityVO vo = new CommodityVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

}
