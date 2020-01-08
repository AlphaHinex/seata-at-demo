package io.github.alphahinex.demo.seata.at.business.service;

import io.github.alphahinex.demo.seata.at.business.service.model.CommodityVO;
import io.github.alphahinex.demo.seata.at.business.service.model.OrderVO;
import io.github.alphahinex.demo.seata.at.business.vo.BusinessVO;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessService {

    private StorageClient storageClient;
    private OrderClient orderClient;

    @Autowired
    public BusinessService(StorageClient storageClient, OrderClient orderClient) {
        this.storageClient = storageClient;
        this.orderClient = orderClient;
    }

    public ResponseEntity<OrderVO> handleBusiness(BusinessVO businessVO) {
        log.debug("Global transaction id: {}", RootContext.getXID());
        // 1. 扣减库存
        CommodityVO commodityVO = new CommodityVO();
        commodityVO.setCommodityCode(businessVO.getCommodityCode());
        commodityVO.setCount(businessVO.getCount());
        storageClient.decrease(commodityVO);

        // 2. 创建订单
        OrderVO orderVO = new OrderVO();
        orderVO.setUserId(businessVO.getUserId());
        orderVO.setCommodityCode(businessVO.getCommodityCode());
        orderVO.setOrderCount(businessVO.getCount());
        orderVO.setOrderAmount(businessVO.getAmount());
        return orderClient.createOrder(orderVO);
    }

}
