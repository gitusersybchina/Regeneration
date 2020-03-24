package org.demo.lxx.patterns.creation.factory;

import lombok.extern.slf4j.Slf4j;
import org.demo.lxx.patterns.creation.entity.AirplaneProduct;
import org.demo.lxx.patterns.creation.entity.CarProduct;
import org.demo.lxx.patterns.creation.entity.Product;
import org.demo.lxx.patterns.creation.entity.TrainProduct;

/**
 * 简单工厂模式
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2019/10/31 16:52
 */
@Slf4j
public class SampleFactory {

    private static Product Product = new Product() {
        @Override
        public void productInformation() {
            log.info("我是基础产品,没有信息");
        }
    };

    public Product createProduct(Product product) {

        if(product instanceof CarProduct){
            return CarProduct.of("宝马");
        }

        if(product instanceof AirplaneProduct){
            return AirplaneProduct.of("波音747");
        }

        if(product instanceof TrainProduct){
            return TrainProduct.of("和谐号");
        }
        return Product;
    }

}
