package com.tp.di;

import java.util.HashSet;
import java.util.Set;

public class Container {

    private final Set<Class<?>> components = new HashSet<>();

    public void addComponent(Class<?> clz) {
        components.add(clz);
    }

    public Set<Class<?>> getComponents() {
        return components;
    }
}
