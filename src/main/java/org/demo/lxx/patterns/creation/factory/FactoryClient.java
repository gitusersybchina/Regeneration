package org.demo.lxx.patterns.creation.factory;

import lombok.extern.slf4j.Slf4j;
import org.demo.lxx.patterns.creation.entity.Color;
import org.demo.lxx.patterns.creation.entity.AbstractProduct;
import org.demo.lxx.patterns.creation.entity.Shape;
import org.demo.lxx.patterns.creation.entity.AbstractProduct.*;
import org.demo.lxx.patterns.creation.factory.FactoryMethod.*;

/**
 * 各类工厂模式客户端
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/1/1 16:36
 */
@Slf4j
public class FactoryClient {

    public static void main(String[] args) {

        testSampleFactory();
        log.info("================简单工厂测试完成========================");
        // testFactoryMethod();
        // log.info("================工厂方法测试完成========================");
        // testAbstractFactory();
        // log.info("================抽象工厂测试完成========================");
    }

    /**
     * 抽象工厂客户端
     */
    public static void testAbstractFactory() {

        // 获取形状工厂
        AbstractFactory shapeFactory = FactoryBuilder.getFactory(AbstractFactory.FactoryType.SHAPE);
        // 获取形状为 Circle 的对象
        assert shapeFactory != null;
        Shape shape1 = shapeFactory.getShape(Shape.ShapeType.CIRCLE);
        // 调用 Circle 的 draw 方法
        shape1.draw();
        // 获取形状为 Rectangle 的对象
        Shape shape2 = shapeFactory.getShape(Shape.ShapeType.RECTANGLE);
        // 调用 Rectangle 的 draw 方法
        shape2.draw();
        // 获取形状为 Square 的对象
        Shape shape3 = shapeFactory.getShape(Shape.ShapeType.SQUARE);
        // 调用 Square 的 draw 方法
        shape3.draw();

        // 获取颜色工厂
        AbstractFactory colorFactory = FactoryBuilder.getFactory(AbstractFactory.FactoryType.COLOR);
        // 获取颜色为 Red 的对象
        assert colorFactory != null;
        Color color1 = colorFactory.getColor(Color.ColorType.RED);
        // 调用 Red 的 fill 方法
        color1.fill();
        // 获取颜色为 Green 的对象
        Color color2 = colorFactory.getColor(Color.ColorType.GREEN);
        // 调用 Green 的 fill 方法
        color2.fill();
        // 获取颜色为 Blue 的对象
        Color color3 = colorFactory.getColor(Color.ColorType.BLUE);
        // 调用 Blue 的 fill 方法
        color3.fill();
    }

    /**
     * 工厂方法客户端
     */
    public static void testFactoryMethod() {

        AbstractProduct product1 = new FactoryOfCar().createProduct();
        product1.productInformation();

        AbstractProduct product2 = new FactoryOfAirplane().createProduct();
        product2.productInformation();

        AbstractProduct product3 = new FactoryOfTrain().createProduct();
        product3.productInformation();
    }

    /**
     * 简单工厂客户端
     */
    public static void testSampleFactory() {

        AbstractProduct product1 = new SampleFactory().createProduct(new CarProduct());
        product1.productInformation();

        AbstractProduct product2 = new SampleFactory().createProduct(new TrainProduct());
        product2.productInformation();

        AbstractProduct product3 = new SampleFactory().createProduct(new AirplaneProduct());
        product3.productInformation();

        AbstractProduct product4 = new SampleFactory().createProduct(new AbstractProduct() {
            @Override
            public void productInformation() {
                super.productInformation();
            }
        });
        product4.productInformation();

        AbstractProduct product5 = new SampleFactory().createProduct(CarProduct.class.getSimpleName());
        product5.productInformation();

        AbstractProduct product6 = new SampleFactory().createProduct(TrainProduct.class.getSimpleName());
        product6.productInformation();

        AbstractProduct product7 = new SampleFactory().createProduct(AirplaneProduct.class.getSimpleName());
        product7.productInformation();

        AbstractProduct product8 = new SampleFactory().createProduct("Abstract");
        product8.productInformation();
    }
}
