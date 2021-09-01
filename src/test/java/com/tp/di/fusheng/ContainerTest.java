package com.tp.di.fusheng;

import com.thoughtworks.fusheng.integration.junit5.FuShengTest;
import com.tp.di.Container;
import com.tp.di.testDummies.*;

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

    public String createCarFromContainer() {
        Container container = new Container();
        container.addComponent(Engine.class);
        container.addComponent(Car.class);

        Car car = container.getInstance(Car.class);
        return car.getEngine().start();
    }

    public String createCarFromNew() {
        Engine engine = new Engine();
        Car car1 = new Car(engine);
        return car1.getEngine().start();
    }

    public String createCarWithIEngineFromContainer(){
        Container container = new Container();
        container.addComponent(EngineA.class);
        container.addComponent(EngineB.class);
        container.addComponent(Car.class);
        Car car = container.getInstance(Car.class);
        return car.getEngine().start();
    }
}
