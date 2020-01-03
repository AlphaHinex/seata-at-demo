package io.github.alphahinex.demo.seata.at.business.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BusinessVO {

    private String userId;
    private String commodityCode;
    private String name;
    private Integer count;
    private BigDecimal amount;

}
