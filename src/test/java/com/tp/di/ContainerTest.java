package com.tp.di;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    public void should_add_component_to_container(){
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

}