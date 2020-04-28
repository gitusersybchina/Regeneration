package org.demo.lxx.patterns.creation.entity;


import lombok.extern.slf4j.Slf4j;

/**
 * 抽象产品角色
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/1/1 16:07
 */
public interface Color {

    /**
     * 产品图形填充颜色
     */
    void fill();

    /**
     * 颜色种类
     */
    interface ColorType {
        String RED = "RED";
        String GREEN = "GREEN";
        String BLUE = "BLUE";
    }

    @Slf4j
    class Green implements Color {
        @Override
        public void fill() {
            log.info("我要把你染成绿色的.");
        }
    }

    @Slf4j
    class Red implements Color {
        @Override
        public void fill() {
            log.info("我要把你染成红色的.");
        }
    }

    @Slf4j
    class Blue implements Color {
        @Override
        public void fill() {
            log.info("我要把你染成蓝色的.");
        }
    }
}