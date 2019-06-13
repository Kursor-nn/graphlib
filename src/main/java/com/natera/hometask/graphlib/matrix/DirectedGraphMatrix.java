package com.natera.hometask.graphlib.matrix;

import com.natera.hometask.graphlib.model.Vertex;

public class DirectedGraphMatrix extends GraphMatrix {
    @Override
    public void addEdge(Vertex from, Vertex to) {
        validateVertexes(from);
        validateVertexes(to);

        matrix.get(from).add(to);
    }

    private void validateVertexes(Vertex vertex){
        if(!matrix.containsKey(vertex)){
            String message = String.format("Vertex '%s' cannot be bind.", vertex);
            throw new IllegalArgumentException(message);
        }

    }
}
