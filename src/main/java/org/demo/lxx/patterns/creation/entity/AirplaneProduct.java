package org.demo.lxx.patterns.creation.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2019/10/31 17:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class AirplaneProduct extends Product {

    private String name;

    private String number;

    private Integer price;

    @Override
    public void productInformation() {

        System.out.println("嗡嗡嗡嗡嗡嗡嗡嗡嗡");
        System.out.println("我是飞机产品,信息:" + this.toString());
    }


    public static AirplaneProduct of(String name) {

        System.out.println("正在生产飞机........");
        return new AirplaneProduct(name, UUID.randomUUID().toString(), 100);
    }
}
