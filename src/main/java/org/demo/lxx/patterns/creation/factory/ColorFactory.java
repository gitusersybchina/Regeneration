package org.demo.lxx.patterns.creation.factory;

import lombok.extern.slf4j.Slf4j;
import org.demo.lxx.patterns.creation.entity.Blue;
import org.demo.lxx.patterns.creation.entity.Color;
import org.demo.lxx.patterns.creation.entity.Green;
import org.demo.lxx.patterns.creation.entity.Red;
import org.demo.lxx.patterns.creation.entity.Shape;

/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/1/1 16:22
 */
@Slf4j
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (Color.ColorType.RED.equalsIgnoreCase(color)) {
            log.info("红彤彤............");
            return new Red();
        }
        if (Color.ColorType.GREEN.equalsIgnoreCase(color)) {
            log.info("绿油油............");
            return new Green();
        }
        if (Color.ColorType.BLUE.equalsIgnoreCase(color)) {
            log.info("蓝蓝的............");
            return new Blue();
        }
        return null;
    }
}
