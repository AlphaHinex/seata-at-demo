package io.github.alphahinex.demo.seata.at.storage.entity;

import io.github.alphahinex.demo.seata.at.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_storage")
@Data
public class StorageEntity extends BaseEntity {

    private String commodityCode;
    private String name;
    private Integer count;

}
