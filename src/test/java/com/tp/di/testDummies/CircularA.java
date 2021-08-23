package com.tp.di.testDummies;

public class CircularA {
    private final CircularB circularB;

    public CircularA(CircularB circularB) {
        this.circularB = circularB;
    }
}
