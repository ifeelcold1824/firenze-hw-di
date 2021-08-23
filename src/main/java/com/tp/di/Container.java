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

    public <T>T getInstance(Class<T> clz) throws Exception {
        if(!components.contains(clz)){
            throw new Exception(clz.getSimpleName() + " is not registered in the container");
        }
        return clz.getConstructor().newInstance();
    }
}
