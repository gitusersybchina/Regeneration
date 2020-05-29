package org.liuxixi.demo.patterns.creation.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 单例模式-枚举实现
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2019/10/31 16:07
 */
@Slf4j
public enum SingletonEnum {

    /**
     * 单实例枚举
     */
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String... args) {
        // 单例测试
        SingletonEnum firstSingleton = SingletonEnum.INSTANCE;
        firstSingleton.setObjName("firstName");
        log.info(firstSingleton.getObjName());
        SingletonEnum secondSingleton = SingletonEnum.INSTANCE;
        secondSingleton.setObjName("secondName");
        log.info(firstSingleton.getObjName());
        log.info(secondSingleton.getObjName());
        // 反射获取实例测试
        try {
            SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
            for (SingletonEnum enumConstant : enumConstants) {
                log.info(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
