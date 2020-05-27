package com.jn.promotion.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanCopyUtils {

    /**
     * 对象属性拷贝 <br>
     * 将源对象的属性拷贝到目标对象  不支持复杂对象拷贝
     *
     * @param source 源对象
     * @param target 目标对象
     * @return 是否转换成功
     */
    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    /**
     * 对象属性拷贝 <br>
     * 将源对象的属性拷贝到目标对象
     * 支持复杂对象转换 如list
     *
     * @param source 源对象
     * @param target 目标对象class
     * @return 目标对象
     */
   /* public static <T> T copyProperties(Object source, Class target) {
        if (null == source) {
            return null;
        }
        return new DozerBeanMapper().map(source, (Class<T>) target);
    }*/


    private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>();

    public static <S, T> List<T> copyS2TList(List<S> sList, Class<T> tClass) {
        ArrayList<T> tList = new ArrayList<>(sList.size());

        sList.forEach(item -> {
            tList.add(copyS2T(item, tClass));
        });

        return tList;
    }

    public static <S, T> T copyS2T(S source, T target) {
        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());

        beanCopier.copy(source, target, null);

        return target;
    }

    public static <S, T> T copyS2T(S source, Class<T> tClass) {
        T t;

        try {
            t = tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("create new instance of " + tClass + " failed: %s");
        }

        BeanCopier beanCopier = getBeanCopier(source.getClass(), tClass);

        beanCopier.copy(source, t, null);

        return t;
    }

    private static BeanCopier getBeanCopier(Class sourceClass, Class targetClass) {
        String copierKey = generateKey(sourceClass, targetClass);
        BeanCopier copier = BEAN_COPIER_MAP.get(copierKey);

        if (null == copier) {
            copier = BeanCopier.create(sourceClass, targetClass, false);

            BEAN_COPIER_MAP.put(copierKey, copier);
        }

        return copier;
    }

    private static String generateKey(Class cl1, Class cl2) {
        return cl1.getName() + "_" + cl2.getName();
    }

}
