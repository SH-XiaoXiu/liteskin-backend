package cn.xiuxius.mc.liteskin.security.account.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LSAccount {
    boolean fullRequired() default true;
    boolean emailRequired() default false;
    boolean idRequired() default false;
}
