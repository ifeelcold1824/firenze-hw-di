package com.tp.di;

import com.tp.di.exception.BaseException;
import com.tp.di.exception.ComponentNotRegisteredException;
import com.tp.di.exception.NoInstantiableConstructorException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Container {

    private final Set<Class<?>> components = new HashSet<>();

    public void addComponent(Class<?> clz) {
        components.add(clz);
    }

    public Set<Class<?>> getComponents() {
        return components;
    }

    public <T> T getInstance(Class<T> clz) {
        if (!components.contains(clz)) {
            throw new ComponentNotRegisteredException(clz.getSimpleName() + " is not registered in the container");
        }

        Constructor<?> constructor = getInjectableConstructor(clz);
        Object[] params = Arrays.stream(constructor.getParameters())
                .map(parameter -> getInstance(parameter.getType()))
                .toArray();

        try {
            return (T) constructor.newInstance(params);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            throw new BaseException(ex);
        }
    }

    private Constructor<?> getInjectableConstructor(Class<?> clz) {
        return Arrays.stream(clz.getConstructors())
                .filter(constructor ->
                        Arrays.stream(constructor.getParameterTypes())
                                .allMatch(param -> components.contains(param) && param != clz)
                )
                .findFirst()
                .orElseThrow(
                        () -> new NoInstantiableConstructorException("Could not find a instantiable constructor to instantiate " + clz.getSimpleName() + ".")
                );
    }
}
