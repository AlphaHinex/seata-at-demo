package io.github.alphahinex.demo.seata.at.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    /**
     * 返回 POST 请求的响应
     * 创建实体成功时返回 201 Created 状态及被创建的实体
     *
     * @param entity 被创建的实体
     * @param <T>    实体类型
     * @return POST 请求的响应
     */
    protected <T> ResponseEntity<T> responseOfPost(T entity) {
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

}
