package com.cat.external.http.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Request {
    public int Method() default 0;

    public String Action() default "";

    public boolean CacheEnable() default false;
}
