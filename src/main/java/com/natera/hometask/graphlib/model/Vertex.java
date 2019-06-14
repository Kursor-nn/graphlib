package com.natera.hometask.graphlib.model;

import java.util.Objects;

public class Vertex {
    private final Object data;

    public Vertex(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Vertex vertex = (Vertex)obj;
        return Objects.equals(this.data, vertex.data);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + super.hashCode();
        result = prime * result + ((data == null) ? 0 : data.hashCode());

        return result;
    }
}
