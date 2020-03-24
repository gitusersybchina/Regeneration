package org.demo.lxx.patterns.creation.entity;

import lombok.extern.slf4j.Slf4j;

/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/1/1 16:08
 */
@Slf4j
public class Green implements Color {

    @Override
    public void fill() {
        log.info("我要把你变成绿色的.");
    }
}