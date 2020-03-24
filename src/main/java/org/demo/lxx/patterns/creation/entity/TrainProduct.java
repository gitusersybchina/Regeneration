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
public class TrainProduct extends Product {

    private String name;

    private String number;

    private Integer price;

    @Override
    public void productInformation() {

        log.info("呜呜呜呜呜呜呜呜呜");
        log.info("我是火车产品,信息:" + this.toString());
    }

    public static TrainProduct of(String name) {

        log.info("正在生产火车........");
        return new TrainProduct(name, UUID.randomUUID().toString(), 100);
    }
}
