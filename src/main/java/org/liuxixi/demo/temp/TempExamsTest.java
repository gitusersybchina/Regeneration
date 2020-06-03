package org.liuxixi.demo.temp;

/**
 * Description for this class
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/5/28 16:52
 */
public class TempExamsTest {

    /**
     * Test switch null.
     */
    public static void testSwitchNull() {

        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
                break;
        }


    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        testSwitchNull();
    }
}
