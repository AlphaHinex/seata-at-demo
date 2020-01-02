package io.github.alphahinex.demo.seata.at.account.entity;

import io.github.alphahinex.demo.seata.at.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_account")
@Data
public class AccountEntity extends BaseEntity {

    private String userId;
    private Double amount;

}
