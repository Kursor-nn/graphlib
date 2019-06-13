package com.natera.hometask.graphlib.model;

public class Vertex {
    private final Object data;

    public Vertex(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
