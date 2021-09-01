package com.tp.di.fusheng;

import com.thoughtworks.fusheng.integration.junit5.FuShengTest;
import com.tp.di.Container;

@FuShengTest
public class ContainerTest {

    public String createStringFromContainer() {
        Container container = new Container();
        container.addComponent(String.class);
        return container.getInstance(String.class);
    }

    public String createStringFromNew() {
        return new String();
    }
}
