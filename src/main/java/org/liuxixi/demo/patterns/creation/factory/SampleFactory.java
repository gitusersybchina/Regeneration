package org.liuxixi.demo.patterns.creation.factory;

import lombok.extern.slf4j.Slf4j;
import org.liuxixi.demo.patterns.creation.product.AbstractProduct;

/**
 * 简单工厂
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2019/10/31 16:52
 */
@Slf4j
public class SampleFactory {

    private static AbstractProduct Product = new AbstractProduct() {
        @Override
        public void productInformation() {
            log.info("我是基础产品,没有信息");
        }
    };

    public AbstractProduct createProduct(AbstractProduct product) {

        if (product instanceof AbstractProduct.CarProduct) {
            return AbstractProduct.CarProduct.of("宝马");
        }

        if (product instanceof AbstractProduct.AirplaneProduct) {
            return AbstractProduct.AirplaneProduct.of("波音747");
        }

        if (product instanceof AbstractProduct.TrainProduct) {
            return AbstractProduct.TrainProduct.of("和谐号");
        }
        return Product;
    }


    public AbstractProduct createProduct(String args) {

        if (args.equalsIgnoreCase(AbstractProduct.CarProduct.class.getSimpleName())) {
            return AbstractProduct.CarProduct.of("宝马");
        }

        if (args.equalsIgnoreCase(AbstractProduct.AirplaneProduct.class.getSimpleName())) {
            return AbstractProduct.AirplaneProduct.of("波音747");
        }

        if (args.equalsIgnoreCase(AbstractProduct.TrainProduct.class.getSimpleName())) {
            return AbstractProduct.TrainProduct.of("和谐号");
        }
        return Product;
    }
}
