package utilTest.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解类
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {
    /**
     * 方法名
     * @return
     */
    String name() default "";

    /**
     * 方法描述
     * @return
     */
    String desc() default "";
}
