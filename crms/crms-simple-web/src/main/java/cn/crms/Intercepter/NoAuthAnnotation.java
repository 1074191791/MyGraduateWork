/**
 * 
 */
package cn.crms.Intercepter;

import java.lang.annotation.*;

/**
 * 
 * 权限校验注解,作用于方法之上.
 * 
 * @author fyh
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoAuthAnnotation {

}
