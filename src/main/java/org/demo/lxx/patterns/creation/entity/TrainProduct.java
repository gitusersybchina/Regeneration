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
public class TrainProduct extends Product {

    private String name;

    private String number;

    private Integer price;

    @Override
    public void productInformation() {

        System.out.println("呜呜呜呜呜呜呜呜呜");
        System.out.println("我是火车产品,信息:" + this.toString());
    }

    public static TrainProduct of(String name) {

        System.out.println("正在生产火车........");
        return new TrainProduct(name, UUID.randomUUID().toString(), 100);
    }
}
