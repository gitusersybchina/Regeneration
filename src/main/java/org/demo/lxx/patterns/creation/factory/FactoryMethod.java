package org.demo.lxx.patterns.creation.factory;

import org.demo.lxx.patterns.creation.entity.AbstractProduct;
import org.demo.lxx.patterns.creation.entity.AbstractProduct.*;

/**
 * 工厂方法中，是由子类工厂来创建产品
 *
 * @author : xiaoshi
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

            return CarProduct.of("海马汽车");
        }
    }

    /**
     * 实现工厂方法的火车工厂
     */
    class FactoryOfTrain implements FactoryMethod {
        @Override
        public AbstractProduct createProduct() {

            return TrainProduct.of("和谐号");
        }
    }

    /**
     * 实现工厂方法的飞机工厂
     */
    class FactoryOfAirplane implements FactoryMethod {
        @Override
        public AbstractProduct createProduct() {

            return AirplaneProduct.of("歼-11");
        }
    }
}
