package org.demo.lxx.patterns.creation.factory;

import org.demo.lxx.patterns.creation.entity.AirplaneProduct;
import org.demo.lxx.patterns.creation.entity.Product;

/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2019/11/14 11:05
 */
public class FactoryOfPlane implements FactoryMethod {


    @Override
    public Product createProduct() {

        return AirplaneProduct.of("歼-11");
    }

}
