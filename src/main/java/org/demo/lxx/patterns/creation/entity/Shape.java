package org.demo.lxx.patterns.creation.entity;


/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
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
}
