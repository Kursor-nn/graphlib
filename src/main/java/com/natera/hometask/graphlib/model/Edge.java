package com.natera.hometask.graphlib.model;

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
}
