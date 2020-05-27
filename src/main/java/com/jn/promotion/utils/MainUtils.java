package com.jn.promotion.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MainUtils {


    /**
     * 根据页码和页容量截取list
     *
     * @param list
     * @param current
     * @param size
     * @param <T>
     * @return
     */
    public static <T> List<T> subListByCurrentAndSize(
            List<T> list,
            Integer current,
            Integer size
    ) {

        //下标
        int start = 0;
        int end = size;

        if (current.intValue() > 1) {
            start = (current - 1) * size;
            end = start + size;
        }

        if (start >= list.size()) {
            start = 0;
        }

        if (end >= list.size()) {
            end = list.size() - 1;
        }

        return list.subList(start, end);
    }

    /**
     * @Description 读取流信息
     * @Author lxy
     * @Date 2019/6/3 18:00
     */
    public static String inputStreamToString(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }


    /**
     * 判断是否是数字
     *
     * @param str
     * @return
     */
    public final static boolean isNumeric(String str) {
        if (MainUtils.stringIsNotEmpty(str)) {
            return str.matches("^[0-9]*$");
        }
        return false;
    }

    /**
     * 对象是否非null
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean tIsNotNull(T t) {
        return !tIsNull(t);
    }

    /**
     * 对象是否为null
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean tIsNull(T t) {
        return t == null;
    }

    /**
     * string是否为empty
     *
     * @param str
     * @param <T>
     * @return
     */
    public static <T> boolean stringIsEmpty(String str) {
        if (tIsNull(str)) {
            return true;
        }
        return str.isEmpty();
    }

    /**
     * string是否非empty
     *
     * @param str
     * @param <T>
     * @return
     */
    public static <T> boolean stringIsNotEmpty(String str) {
        return !stringIsEmpty(str);
    }

    /**
     * 集合是否是empty
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean collectionIsEmpty(T t) {
        if (tIsNull(t)) {
            return true;
        }
        if (t instanceof Collection) {
            return ((Collection) t).isEmpty();
        }
        if (t instanceof Map) {
            return ((Map) t).isEmpty();
        }
        return true;
    }

    /**
     * 集合是否不是empty
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean collectionIsNotEmpty(T t) {
        return !collectionIsEmpty(t);
    }


}
