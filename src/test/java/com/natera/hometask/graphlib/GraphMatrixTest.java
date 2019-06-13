package com.natera.hometask.graphlib;

import com.natera.hometask.graphlib.matrix.DirectedGraphMatrix;
import com.natera.hometask.graphlib.matrix.GraphMatrix;
import com.natera.hometask.graphlib.matrix.NonDirectedGraphMatrix;
import com.natera.hometask.graphlib.model.Edge;
import com.natera.hometask.graphlib.model.Vertex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphMatrixTest {

    @Test
    public void fillMatrixTest(){
        GraphMatrix matrix = new DirectedGraphMatrix();
        Vertex vertex1 = new Vertex("Vertex 1");
        Vertex vertex2 = new Vertex("Vertex 2");
        Vertex vertex3 = new Vertex("Vertex 3");
        Vertex vertex4 = new Vertex("Vertex 4");
        Vertex vertex5 = new Vertex("Vertex 5");

        matrix.addVertex(vertex1);
        matrix.addVertex(vertex2);
        matrix.addVertex(vertex3);
        matrix.addVertex(vertex4);
        matrix.addVertex(vertex5);

        matrix.addEdge(vertex2, vertex3);
        matrix.addEdge(vertex1, vertex2);
        matrix.addEdge(vertex3, vertex4);
        matrix.addEdge(vertex2, vertex4);
        matrix.addEdge(vertex4, vertex1);

        matrix.getPath(vertex5, vertex1);
    }

    @Test
    public void fillNonDirectedGraph(){
        GraphMatrix matrix = new NonDirectedGraphMatrix();
        Vertex vertex1 = new Vertex("Vertex 1");
        Vertex vertex2 = new Vertex("Vertex 2");
        Vertex vertex3 = new Vertex("Vertex 3");
        Vertex vertex4 = new Vertex("Vertex 4");

        matrix.addVertex(vertex1);
        matrix.addVertex(vertex2);
        matrix.addVertex(vertex3);
        matrix.addVertex(vertex4);

        matrix.addEdge(vertex2, vertex3);
        matrix.addEdge(vertex1, vertex2);
        matrix.addEdge(vertex3, vertex4);
        matrix.addEdge(vertex2, vertex4);
        matrix.addEdge(vertex4, vertex1);

        matrix.getPath(vertex2, vertex1);
    }

    @Test
    public void getPathInDirectedGraphTest(){
        GraphMatrix matrix = new DirectedGraphMatrix();
        Vertex vertex1 = new Vertex("Vertex 1");
        Vertex vertex2 = new Vertex("Vertex 2");

        matrix.addVertex(vertex1);
        matrix.addVertex(vertex2);

        matrix.addEdge(vertex1, vertex2);
        matrix.addEdge(vertex2, vertex1);

        matrix.getPath(vertex2, vertex1);
        matrix.getPath(vertex1, vertex2);
    }

    @Test
    public void getPathInDirectedGraphWythCycleTest(){
        GraphMatrix matrix = new DirectedGraphMatrix();
        Vertex VertexContainer1 = new Vertex("Vertex 1");
        Vertex VertexContainer2 = new Vertex("Vertex 2");

        matrix.addVertex(VertexContainer1);
        matrix.addVertex(VertexContainer2);

        matrix.addEdge(VertexContainer1, VertexContainer2);
        matrix.addEdge(VertexContainer2, VertexContainer1);

        matrix.getPath(VertexContainer2, VertexContainer1);
    }

    @Test
    public void getPathInDirectedGraphWythCycle2Test(){
        GraphMatrix matrix = new DirectedGraphMatrix();
        Vertex vertex1 = new Vertex("Vertex 1");
        Vertex vertex2 = new Vertex("Vertex 2");
        Vertex vertex3 = new Vertex("Vertex 3");
        Vertex vertex4 = new Vertex("Vertex 4");
        Vertex vertex5 = new Vertex("Vertex 5");
        Vertex vertex6 = new Vertex("Vertex 6");
        Vertex vertex7 = new Vertex("Vertex 7");
        Vertex vertex8 = new Vertex("Vertex 8");

        matrix.addVertex(vertex1);
        matrix.addVertex(vertex2);
        matrix.addVertex(vertex3);
        matrix.addVertex(vertex4);
        matrix.addVertex(vertex5);
        matrix.addVertex(vertex6);
        matrix.addVertex(vertex7);
        matrix.addVertex(vertex8);

        matrix.addEdge(vertex1, vertex2);
        matrix.addEdge(vertex1, vertex3);
        matrix.addEdge(vertex2, vertex4);
        matrix.addEdge(vertex3, vertex4);

        matrix.addEdge(vertex4, vertex5);
        matrix.addEdge(vertex4, vertex6);
        matrix.addEdge(vertex6, vertex7);
        matrix.addEdge(vertex5, vertex8);
        matrix.addEdge(vertex7, vertex8);

        List<Edge> path = matrix.getPath(vertex1, vertex7);

        for(Edge edge: path){
            System.out.println(edge);
        }
    }
}
