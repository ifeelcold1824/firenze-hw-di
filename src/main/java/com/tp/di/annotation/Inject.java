package com.tp.di.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
public @interface Inject {
    Class<?> value();
}
