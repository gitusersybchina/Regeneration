package org.demo.lxx.patterns.creation.entity;

import lombok.extern.slf4j.Slf4j;

/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/1/1 15:54
 */
@Slf4j
public class Circle implements Shape {

    @Override
    public void draw() {
        log.info("来，跟我一起画个圆");
    }
}