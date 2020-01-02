package io.github.alphahinex.demo.seata.at.order.entity;

import io.github.alphahinex.demo.seata.at.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_order")
@Data
public class OrderEntity extends BaseEntity {

    private String orderNo;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Double amount;

}
