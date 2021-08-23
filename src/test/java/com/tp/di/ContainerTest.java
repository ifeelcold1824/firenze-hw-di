package com.tp.di;

import com.tp.di.exception.ComponentNotRegisteredException;
import com.tp.di.exception.NoInstantiableConstructorException;
import com.tp.di.testDummies.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    public void should_add_component_to_container() {
        Container container = new Container();
        container.addComponent(String.class);
        Set<Class<?>> components = container.getComponents();

        assertEquals(1, components.size());
        assertTrue(components.contains(String.class));
    }

    @Test
    public void should_instantiate_component() {
        Container container = new Container();
        container.addComponent(String.class);
        String instance = container.getInstance(String.class);

        assertEquals("", instance);
    }

    @Test
    public void should_assemble_components() {
        Container container = new Container();
        container.addComponent(Engine.class);
        container.addComponent(Car.class);
        Car car = container.getInstance(Car.class);

        assertEquals("started", car.getEngine().start());
    }

    @Test
    public void should_throw_exception_when_no_valid_constructor() {
        Container container = new Container();
        container.addComponent(Car.class);

        assertThrows(NoInstantiableConstructorException.class, () -> container.getInstance(Car.class));
    }

    @Test
    public void should_throw_exception_when_component_not_registered() {
        Container container = new Container();

        assertThrows(ComponentNotRegisteredException.class, () -> container.getInstance(Car.class));
    }

    @Test
    public void should_throw_exception_when_found_circular_dependency() {
        Container container = new Container();
        container.addComponent(CircularA.class);
        container.addComponent(CircularB.class);
        container.addComponent(CircularC.class);

        assertThrows(CircularDependencyException.class, () -> container.getInstance(CircularA.class));
    }

}