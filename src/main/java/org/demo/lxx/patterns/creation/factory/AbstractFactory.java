package org.demo.lxx.patterns.creation.factory;

import org.demo.lxx.patterns.creation.entity.Color;
import org.demo.lxx.patterns.creation.entity.Shape;

/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/1/1 16:15
 */
public abstract class AbstractFactory {

    /**
     * 获取颜色
     *
     * @param color 颜色名称
     * @return Color
     */
    public abstract Color getColor(String color);

    /**
     * 获取图形
     *
     * @param shape 图形名称
     * @return Shape
     */
    public abstract Shape getShape(String shape);

    /**
     * 工厂类型
     */
    interface FactoryType {
        String COLOR = "COLOR";
        String SHAPE = "SHAPE";
    }
}
