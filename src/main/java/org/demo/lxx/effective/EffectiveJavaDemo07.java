package org.demo.lxx.effective;


import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 消除过期的对象引用
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/3/25 10:27
 */
public class EffectiveJavaDemo07 {

    /**
     * 存在内存泄漏的栈
     */
    public static class Stack {

        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object element) {
            elements[size++] = element;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            // 此时直接出栈后，数组中仍然存在这个对象引用导致内存泄漏
            // return elements[--size];

            // 需要手动解除引用
            Object result = elements[--size];
            elements[size] = null;
            return result;
        }

        /**
         * 确保至少有一个元素的空间,每次阵列需要增长时，容量大约都会增加一倍
         */
        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }
}
