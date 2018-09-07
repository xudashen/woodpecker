package com.woodpecker.framework.annotation;


import java.lang.annotation.*;

/**
 * 注解描述:〈标记字段、参数为需要加密〉
 *
 * @author: jinjianxu
 * @since: 1.0
 */
@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Encrypt {

}
