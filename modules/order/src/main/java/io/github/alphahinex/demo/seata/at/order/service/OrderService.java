package io.github.alphahinex.demo.seata.at.order.service;

import io.github.alphahinex.demo.seata.at.order.entity.OrderEntity;
import io.github.alphahinex.demo.seata.at.order.repository.OrderRepository;
import io.github.alphahinex.demo.seata.at.order.service.model.AccountVO;
import io.github.alphahinex.demo.seata.at.order.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private AccountClient accountClient;
    private OrderRepository repository;

    @Autowired
    public OrderService(AccountClient accountClient, OrderRepository repository) {
        this.accountClient = accountClient;
        this.repository = repository;
    }

    public OrderVO createOrder(OrderVO vo) {
        AccountVO accountVO = new AccountVO();
        accountVO.setUserId(vo.getUserId());
        accountVO.setAmount(vo.getOrderAmount());
        // 扣减用户账户
        accountClient.decrease(accountVO);

        vo.setOrderNo(UUID.randomUUID().toString());
        // 生成订单
        OrderEntity entity = new OrderEntity();
        BeanUtils.copyProperties(vo, entity);
        entity.setCount(vo.getOrderCount());
        entity.setAmount(vo.getOrderAmount().doubleValue());

        repository.save(entity);
        vo.setId(entity.getId());

        return vo;
    }

}
