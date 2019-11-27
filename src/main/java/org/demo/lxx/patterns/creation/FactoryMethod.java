package org.demo.lxx.patterns.creation;

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

    /**
     * 工厂方法客户端
     *
     * @param args args
     */
    static void main(String[] args) {

        Product product1 = new FactoryOfCar().createProduct();
        product1.productInformation();

        Product product2 = new FactoryOfPlane().createProduct();
        product2.productInformation();

        Product product3 = new FactoryOfTrain().createProduct();
        product3.productInformation();
    }

}
