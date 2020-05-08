package org.demo.lxx.patterns.creation.factory;

import org.demo.lxx.patterns.creation.product.Color;
import org.demo.lxx.patterns.creation.product.Shape;

/**
 * 抽象工厂,生产相同等级产品
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/1/1 16:15
 */
public interface AbstractFactory {

    /**
     * 获取颜色
     *
     * @param color 颜色名称
     * @return Color
     */
    Color getColor(String color);

    /**
     * 获取图形
     *
     * @param shape 图形名称
     * @return Shape
     */
    Shape getShape(String shape);

    /**
     * 工厂类型
     */
    interface FactoryType {
        String COLOR = "COLOR";
        String SHAPE = "SHAPE";
    }


}
