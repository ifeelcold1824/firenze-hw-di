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

}