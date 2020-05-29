package org.liuxixi.demo.patterns.creation.factory;

import lombok.extern.slf4j.Slf4j;
import org.liuxixi.demo.patterns.creation.product.Color;
import org.liuxixi.demo.patterns.creation.product.Shape;

/**
 * 具体颜色工厂-实现抽象工厂
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/1/1 16:22
 */
@Slf4j
public class ConcreteColorFactory implements AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (Color.ColorType.RED.equalsIgnoreCase(color)) {
            log.info("红彤彤............");
            return new Color.Red();
        }
        if (Color.ColorType.GREEN.equalsIgnoreCase(color)) {
            log.info("绿油油............");
            return new Color.Green();
        }
        if (Color.ColorType.BLUE.equalsIgnoreCase(color)) {
            log.info("蓝蓝的............");
            return new Color.Blue();
        }
        return null;
    }
}
