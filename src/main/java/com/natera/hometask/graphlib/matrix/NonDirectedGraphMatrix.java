package com.natera.hometask.graphlib.matrix;

import com.natera.hometask.graphlib.model.Vertex;

public class NonDirectedGraphMatrix extends GraphMatrix {
    @Override
    public void addEdge(Vertex from, Vertex to) {
        matrix.get(from).add(to);
        matrix.get(to).add(from);
    }
}