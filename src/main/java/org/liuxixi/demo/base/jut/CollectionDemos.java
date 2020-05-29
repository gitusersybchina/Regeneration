package org.liuxixi.demo.base.jut;

import java.util.Collections;
import java.util.List;

/**
 * Description for this class
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/5/14 17:19
 */
public class CollectionDemos {


    public static void main(String[] args) {

        final List<Object> objects = new java.util.ArrayList<>(Collections.emptyList());
        objects.add("xxxxx");

        System.out.println(objects);
    }
}
