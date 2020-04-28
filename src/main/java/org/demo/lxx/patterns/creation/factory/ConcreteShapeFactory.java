package org.demo.lxx.patterns.creation.factory;

import lombok.extern.slf4j.Slf4j;
import org.demo.lxx.patterns.creation.entity.Color;
import org.demo.lxx.patterns.creation.entity.Shape;
import org.slf4j.Logger;

/**
 * 具体形状工厂-实现抽象工厂
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/1/1 16:19
 */
@Slf4j
public class ConcreteShapeFactory implements AbstractFactory {

    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType){
        return getShape(shapeType, log);
    }

    public static Shape getShape(String shapeType, Logger log) {
        if(shapeType == null){
            return null;
        }
        if(Shape.ShapeType.CIRCLE.equalsIgnoreCase(shapeType)){
            log.info("正在生产圆形.......");
            return new Shape.Circle();
        }
        if(Shape.ShapeType.RECTANGLE.equalsIgnoreCase(shapeType)){
            log.info("正在生产长方形.......");
            return new Shape.Rectangle();
        }
        if(Shape.ShapeType.SQUARE.equalsIgnoreCase(shapeType)){
            log.info("正在生产正方形.......");
            return new Shape.Square();
        }
        return null;
    }

}