package io.github.alphahinex.demo.seata.at.order.service.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountVO {

    private Integer id;
    private String userId;
    private BigDecimal amount;

}
