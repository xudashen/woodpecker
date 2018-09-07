package com.woodpecker.framework.util;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类描述:〈反射工具类〉
 *
 * @author: jinjianxu
 * @since: 1.0
 */
public class ReflectionUtil {


    /**
     * 方法功能描述: 获取对象的所有声明的字段(包括public、private、proteced)
     *
     * @param object
     * @param containsSuperclassField 是否要获取出父类中的字段
     * @return java.lang.reflect.Field[]
     */
    public Field[] getDeclaredField(Object object, boolean containsSuperclassField) {
        List<Field> fields = new ArrayList<>();
        //判断是否需要获取出父类的字段
        if (containsSuperclassField) {
            //遍历object，一直到Object
            for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
                //获取出当前class的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
                Field[] field = clazz.getDeclaredFields();
                if (null != field && field.length > 0) {
                    fields.addAll(Arrays.asList(field));
                }
            }
        } else {
            //获取出当前class的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
            Class<?> clazz = object.getClass();
            Field[] field = clazz.getDeclaredFields();
            if (null != field && field.length > 0) {
                fields.addAll(Arrays.asList(field));
            }
        }
        return fields.toArray(new Field[fields.size()]);
    }


    /**
     * 方法功能描述: 获取对象的所有声明的字段(包括public、private、proteced)
     *
     * @param clazz
     * @param containsSuperclassField 是否要获取出父类中的字段
     * @return java.lang.reflect.Field[]
     */
    public Field[] getDeclaredField(Class<?> clazz, boolean containsSuperclassField) {
        List<Field> fields = new ArrayList<>();
        //判断是否需要获取出父类的字段
        if (containsSuperclassField) {
            //遍历object，一直到Object
            for (Class<?> clzz = clazz; clzz != Object.class; clzz = clzz.getSuperclass()) {
                //获取出当前class的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
                Field[] field = clzz.getDeclaredFields();
                if (null != field && field.length > 0) {
                    fields.addAll(Arrays.asList(field));
                }
            }
        } else {
            //获取出当前class的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
            Field[] field = clazz.getDeclaredFields();
            if (null != field && field.length > 0) {
                fields.addAll(Arrays.asList(field));
            }
        }
        return fields.toArray(new Field[fields.size()]);
    }


    /**
     * 方法功能描述: 获取对象的所有声明的字段(包括public、private、proteced)
     *
     * @param object
     * @param containsSuperclassField 是否要获取出父类中的字段
     * @return java.lang.reflect.Field[]
     */
    public Field[] getField(Object object) {
        List<Field> fields = new ArrayList<>();
        //获取出当前class所有的公共（public）字段，包括父类中的字段。
        Class<?> clazz = object.getClass();
        Field[] field = clazz.getFields();
        if (null != field && field.length > 0) {
            fields.addAll(Arrays.asList(field));
        }
        return fields.toArray(new Field[fields.size()]);
    }


    /**
     * 方法功能描述: 获取对象的所有声明的字段(包括public、private、proteced)
     *
     * @param clazz
     * @param containsSuperclassField 是否要获取出父类中的字段
     * @return java.lang.reflect.Field[]
     */
    public Field[] getField(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        //获取出当前class所有的公共（public）字段，包括父类中的字段。
        Field[] field = clazz.getFields();
        if (null != field && field.length > 0) {
            fields.addAll(Arrays.asList(field));
        }
        return fields.toArray(new Field[fields.size()]);
    }


}
