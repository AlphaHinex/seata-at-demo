package io.github.alphahinex.demo.seata.at.business.service.model;

import lombok.Data;

@Data
public class CommodityVO {

    private Integer id;
    private String commodityCode;
    private String name;
    private Integer count;

}
