package org.demo.lxx.patterns.creation.factory;

import org.demo.lxx.patterns.creation.entity.Product;

/**
 * 工厂方法中，是由子类工厂来创建产品
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2019/11/14 10:49
 */
public interface FactoryMethod {

    /**
     * 默认工厂方法
     *
     * @return {@link Product}
     */
    default Product createProduct() {
        return new Product() {
        };
    }

}
