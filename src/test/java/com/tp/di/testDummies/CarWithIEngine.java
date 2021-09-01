package com.tp.di.testDummies;

import com.tp.di.annotation.Inject;

public class CarWithIEngine {
    private final IEngine engine;

    public CarWithIEngine(@Inject(EngineB.class) IEngine engine) {
        this.engine = engine;
    }


    public IEngine getEngine() {
        return engine;
    }
}
