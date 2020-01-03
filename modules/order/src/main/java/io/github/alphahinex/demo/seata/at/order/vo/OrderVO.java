package io.github.alphahinex.demo.seata.at.order.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderVO {

    private String id;
    private String orderNo;
    private String userId;
    private String commodityCode;
    private Integer orderCount;
    private BigDecimal orderAmount;

}
