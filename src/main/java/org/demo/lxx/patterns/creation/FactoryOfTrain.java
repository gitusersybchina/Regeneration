package org.demo.lxx.patterns.creation;

import org.demo.lxx.patterns.creation.entity.Product;
import org.demo.lxx.patterns.creation.entity.TrainProduct;

/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2019/11/14 11:05
 */
public class FactoryOfTrain implements FactoryMethod {


    @Override
    public Product createProduct() {

        return TrainProduct.of("和谐号");
    }

}
