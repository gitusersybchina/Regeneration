package org.liuxixi.demo.patterns.creation.factory;

import org.liuxixi.demo.patterns.creation.product.AbstractProduct;

/**
 * 工厂方法中，是由子类工厂来创建产品
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2019/11/14 10:49
 */
public interface FactoryMethod {

    /**
     * 默认工厂方法
     * 工厂方法中，是由子类工厂来创建产品
     *
     * @return {@link AbstractProduct}
     */
    default AbstractProduct createProduct() {
        return new AbstractProduct() {
        };
    }

    /**
     * 实现工厂方法的汽车工厂
     */
    class FactoryOfCar implements FactoryMethod {
        @Override
        public AbstractProduct createProduct() {

            return AbstractProduct.CarProduct.of("海马汽车");
        }
    }

    /**
     * 实现工厂方法的火车工厂
     */
    class FactoryOfTrain implements FactoryMethod {
        @Override
        public AbstractProduct createProduct() {

            return AbstractProduct.TrainProduct.of("和谐号");
        }
    }

    /**
     * 实现工厂方法的飞机工厂
     */
    class FactoryOfAirplane implements FactoryMethod {
        @Override
        public AbstractProduct createProduct() {

            return AbstractProduct.AirplaneProduct.of("歼-11");
        }
    }
}
