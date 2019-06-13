package com.natera.hometask.graphlib.nondirected;

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
    public void bindExistVertexWithNotExist(){
        GraphMatrix matrix = new NonDirectedGraphMatrix();
        Vertex vertex1 = new Vertex("vertex 1");
        Vertex vertex2 = new Vertex("vertex 2");

        matrix.addVertex(vertex1);
        matrix.addEdge(vertex1, vertex2);
    }
}
