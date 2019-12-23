package io.github.alphahinex.demo.seata.at.storage.service;

import io.github.alphahinex.demo.seata.at.storage.repository.StorageRepository;
import io.github.alphahinex.demo.seata.at.storage.vo.CommodityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    private StorageRepository repository;

    @Autowired
    public StorageService(StorageRepository repository) {
        this.repository = repository;
    }

    public Integer decrease(CommodityVO vo) {
        return repository.decrease(vo.getCount(), vo.getCommodityCode());
    }

}
