package org.liuxixi.demo.base.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Description for this class
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/6/2 11:36
 */
@Slf4j
public class ToMapDemos {

    public static void main(String[] args) {
        testMapOrStreamAppendSort();
    }

    public static void testMapOrStreamAppendSort() {

        List<IntervalDTO> select = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            final IntervalDTO intervalDTO = new IntervalDTO();
            intervalDTO.setStart(new BigDecimal(i));
            intervalDTO.setEnd(new BigDecimal((i + 1) * 10));
            select.add(intervalDTO);
        }

        long start = System.currentTimeMillis();
        final Map<BigDecimal, BigDecimal> map = select
                .stream()
                .collect(Collectors.toMap(
                        IntervalDTO::getStart,
                        IntervalDTO::getEnd,
                        (key1, key2) -> key1,
                        TreeMap::new));
        final List<String> list = new ArrayList<>(map.size());
        final StringBuilder stringBuilder = new StringBuilder(8);
        map.forEach((key, value) -> {
            stringBuilder.append("[");
            stringBuilder.append(key.toString());
            stringBuilder.append(",");
            stringBuilder.append(value.toString());
            stringBuilder.append("]");
            list.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        });
        log.debug("区间信息【{}】", list.toString());
        list.clear();
        log.info("通过TreeMap排序拼接耗时【{}】毫秒", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        select.stream().sorted(Comparator.comparing(IntervalDTO::getStart)).forEach((key) -> {
            stringBuilder.append("[");
            stringBuilder.append(key.getStart().toString());
            stringBuilder.append(",");
            stringBuilder.append(key.getEnd().toString());
            stringBuilder.append("]");
            list.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        });
        log.debug("区间信息【{}】", list.toString());
        list.clear();
        log.info("通过Stream排序拼接耗时【{}】毫秒", System.currentTimeMillis() - start);
    }

    private static String apply(BigDecimal key, BigDecimal value) {

        return "[" +
                key.toString() +
                "," +
                value.toString() +
                "]";
    }

    @Data
    public static class IntervalDTO {

        BigDecimal start;
        BigDecimal end;
    }


}
