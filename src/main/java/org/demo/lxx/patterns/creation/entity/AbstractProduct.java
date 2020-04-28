package org.demo.lxx.patterns.creation.entity;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 抽象产品角色
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2019/10/31 16:54
 */
@NoArgsConstructor
@Data
@Slf4j
public abstract class AbstractProduct {

    public String name;

    public String number;

    public Integer price;

    /**
     * 返回基础产品信息
     */
    public void productInformation() {
        log.info("我是基础产品,没有信息");
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class AirplaneProduct extends AbstractProduct {

        public AirplaneProduct(String name, String number, int price) {
            super();
            this.name = name;
            this.number = number;
            this.price = price;
        }

        @Override
        public void productInformation() {
            log.info("嗡嗡嗡嗡嗡嗡嗡嗡嗡");
            log.info("我是飞机产品,信息:" + this.toString());
        }

        public static AirplaneProduct of(String name) {

            log.info("正在生产飞机........");
            return new AirplaneProduct(name, UUID.randomUUID().toString(), 10000);
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class TrainProduct extends AbstractProduct {

        public TrainProduct(String name, String number, int price) {
            super();
            this.name = name;
            this.number = number;
            this.price = price;
        }

        @Override
        public void productInformation() {
            log.info("呜呜呜呜呜呜呜呜呜");
            log.info("我是火车产品,信息:" + this.toString());
        }

        public static TrainProduct of(String name) {

            log.info("正在生产火车........");
            return new TrainProduct(name, UUID.randomUUID().toString(), 1000);
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @AllArgsConstructor
    public static class CarProduct extends AbstractProduct {

        public CarProduct(String name, String number, int price) {
            super();
            this.name = name;
            this.number = number;
            this.price = price;
        }

        @Override
        public void productInformation() {
            log.info("滴滴滴滴滴滴滴滴滴");
            log.info("我是汽车产品,信息:" + this.toString());
        }

        public static CarProduct of(String name) {

            log.info("正在生产汽车........");
            return new CarProduct(name, UUID.randomUUID().toString(), 100);
        }
    }
}
