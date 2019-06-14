package com.natera.hometask.graphlib.model;

import java.util.Objects;

public class Edge {
    public Edge(){}

    public Edge(Vertex from, Vertex to){
        this.from = from;
        this.to = to;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    @Override
    public String toString() {
        return from.toString() + " -> " + to.toString();
    }

    private Vertex from;
    private Vertex to;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Edge edge = (Edge)obj;
        return Objects.equals(this.from, edge.from)
                && Objects.equals(this.to, edge.to);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((to == null)   ? 0 : to.hashCode());

        return result;
    }
}
