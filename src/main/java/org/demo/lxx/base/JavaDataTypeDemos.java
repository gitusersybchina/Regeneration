package org.demo.lxx.base;


/**
 * Description for this class
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/4/16 16:59
 */
public class JavaDataTypeDemos {

    public static void testFloat() {

        // false
        System.out.println(0.1 * 3 == 0.3);
        // false
        System.out.println(0.1f * 3 == 0.3);
        // false
        System.out.println(0.1 * 3 == 0.3f);
        // true
        System.out.println(0.1f * 3 == 0.3f);
    }


}