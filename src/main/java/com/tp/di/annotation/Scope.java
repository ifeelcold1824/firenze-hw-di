package com.tp.di.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Scope {
    InjectionScope value();
}

