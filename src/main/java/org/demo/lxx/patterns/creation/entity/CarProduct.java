package org.demo.lxx.patterns.creation.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class CarProduct extends Product {

    private String name;

    private String number;

    private Integer price;

    @Override
    public void productInformation() {

        log.info("滴滴滴滴滴滴滴");
        log.info("我是汽车产品,信息:" + this.toString());
    }


    public static CarProduct of(String name) {

        log.info("正在生产汽车........");
        return new CarProduct(name, UUID.randomUUID().toString(), 100);
    }
}
