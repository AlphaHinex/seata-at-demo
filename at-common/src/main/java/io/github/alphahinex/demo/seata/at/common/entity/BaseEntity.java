package io.github.alphahinex.demo.seata.at.common.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class BaseEntity {

    private static final long serialVersionUID = 5326198256959320881L;

    /**
     * 唯一标识
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Getter
    @Setter
    protected String id;

}
