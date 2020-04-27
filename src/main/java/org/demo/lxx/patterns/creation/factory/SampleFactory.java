package org.demo.lxx.patterns.creation.factory;

import lombok.extern.slf4j.Slf4j;
import org.demo.lxx.patterns.creation.entity.AbstractProduct;
import org.demo.lxx.patterns.creation.entity.AbstractProduct.*;

/**
 * 简单工厂
 *
 * @author : yinbo.shi@hand-china.com
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

        if (product instanceof CarProduct) {
            return CarProduct.of("宝马");
        }

        if (product instanceof AirplaneProduct) {
            return AirplaneProduct.of("波音747");
        }

        if (product instanceof TrainProduct) {
            return TrainProduct.of("和谐号");
        }
        return Product;
    }


    public AbstractProduct createProduct(String args) {

        if (args.equalsIgnoreCase(CarProduct.class.getSimpleName())) {
            return CarProduct.of("宝马");
        }

        if (args.equalsIgnoreCase(AirplaneProduct.class.getSimpleName())) {
            return AirplaneProduct.of("波音747");
        }

        if (args.equalsIgnoreCase(TrainProduct.class.getSimpleName())) {
            return TrainProduct.of("和谐号");
        }
        return Product;
    }
}
