package org.demo.lxx.patterns.creation.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 工厂创建引导类
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/1/1 16:31
 */
@Slf4j
public class FactoryBuilder {

    /**
     * 根据工厂类型获取对应工厂
     *
     * @param choice 工厂类型
     * @return 工厂
     */
    public static AbstractFactory getFactory(String choice) {
        if (AbstractFactory.FactoryType.SHAPE.equalsIgnoreCase(choice)) {
            log.info("你的产品将由图形工厂来生产..............");
            return new ConcreteShapeFactory();
        }
        if (AbstractFactory.FactoryType.COLOR.equalsIgnoreCase(choice)) {
            log.info("你的产品将由颜料工厂来生产..............");
            return new ConcreteColorFactory();
        }
        return null;
    }
}
