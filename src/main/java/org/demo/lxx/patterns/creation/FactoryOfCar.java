package org.demo.lxx.patterns.creation;

import org.demo.lxx.patterns.creation.entity.CarProduct;
import org.demo.lxx.patterns.creation.entity.Product;

/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2019/11/14 10:55
 */
public class FactoryOfCar implements FactoryMethod {


    @Override
    public Product createProduct() {

        return CarProduct.of("海马汽车");
    }
}
