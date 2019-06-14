package com.natera.hometask.graphlib.directedGraph;

import com.natera.hometask.graphlib.matrix.DirectedGraphMatrix;
import com.natera.hometask.graphlib.matrix.GraphMatrix;
import com.natera.hometask.graphlib.matrix.NonDirectedGraphMatrix;
import com.natera.hometask.graphlib.model.Vertex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void bindExistVertexWithNotExistDirectedGraph(){
        GraphMatrix matrix = new DirectedGraphMatrix();
        validate(matrix);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bindExistVertexWithNotExistNonDirectedGraph(){
        NonDirectedGraphMatrix matrix = new NonDirectedGraphMatrix();
        validate(matrix);
    }

    private void validate(GraphMatrix matrix){
        Vertex vertex1 = new Vertex("vertex 1");
        Vertex vertex2 = new Vertex("vertex 2");

        matrix.addVertex(vertex1);
        matrix.addEdge(vertex1, vertex2);
    }
}