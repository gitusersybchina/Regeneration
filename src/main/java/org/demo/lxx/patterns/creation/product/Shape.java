package org.demo.lxx.patterns.creation.product;


import lombok.extern.slf4j.Slf4j;

/**
 * 抽象产品角色
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/1/1 15:46
 */
public interface Shape {

    /**
     * 抽象产品行为
     */
    void draw();

    /**
     * 图形种类
     */
    interface ShapeType {
        String CIRCLE = "CIRCLE";
        String RECTANGLE = "RECTANGLE";
        String SQUARE = "SQUARE";
    }

    @Slf4j
    class Circle implements Shape {
        @Override
        public void draw() {
            log.info("来，左边跟我一起画个圆");
        }
    }

    @Slf4j
    class Rectangle implements Shape {
        @Override
        public void draw() {
            log.info("来，中间跟我一起画个长方形");
        }
    }

    @Slf4j
    class Square implements Shape {
        @Override
        public void draw() {
            log.info("来，右边跟我一起画个正方形");
        }
    }
}
