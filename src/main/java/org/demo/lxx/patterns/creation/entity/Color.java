package org.demo.lxx.patterns.creation.entity;


/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/1/1 16:07
 */
public interface Color {

    /**
     * 产品图形填充颜色
     */
    void fill();

    /**
     * 颜色种类
     */
    interface ColorType {
        String RED = "RED";
        String GREEN = "GREEN";
        String BLUE = "BLUE";
    }
}