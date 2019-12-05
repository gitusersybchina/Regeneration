package org.demo.lxx.patterns.creation;

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
public class SampleFactory {

    private static Product Product = new Product() {
        @Override
        public void productInformation() {
            System.out.println("我是基础产品,没有信息");
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


    public static void main(String[] args) {

        Product product1 = new SampleFactory().createProduct(new CarProduct());
        Product product2 = new SampleFactory().createProduct(new TrainProduct());
        Product product3 = new SampleFactory().createProduct(new AirplaneProduct());

        product1.productInformation();
        product2.productInformation();
        product3.productInformation();

        Product product4 = new SampleFactory().createProduct(new Product());
        product4.productInformation();
    }

}
