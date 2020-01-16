package io.github.alphahinex.demo.seata.at.order.repository;

import io.github.alphahinex.demo.seata.at.order.entity.OrderEntity;
import io.github.springroll.base.jpa.BaseRepository;

public interface OrderRepository extends BaseRepository<OrderEntity, String> {
}
