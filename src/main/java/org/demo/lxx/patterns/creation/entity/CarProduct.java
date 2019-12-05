package org.demo.lxx.patterns.creation.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2019/10/31 16:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarProduct extends Product {

    private String name;

    private String number;

    private Integer price;

    @Override
    public void productInformation() {

        System.out.println("滴滴滴滴滴滴滴");
        System.out.println("我是汽车产品,信息:" + this.toString());
    }


    public static CarProduct of(String name) {

        System.out.println("正在生产汽车........");
        return new CarProduct(name, UUID.randomUUID().toString(), 100);
    }
}
