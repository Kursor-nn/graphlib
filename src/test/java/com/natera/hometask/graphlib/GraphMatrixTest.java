package com.natera.hometask.graphlib;

import com.natera.hometask.graphlib.matrix.DirectedGraphMatrix;
import com.natera.hometask.graphlib.matrix.GraphMatrix;
import com.natera.hometask.graphlib.matrix.NonDirectedGraphMatrix;
import com.natera.hometask.graphlib.model.Edge;
import com.natera.hometask.graphlib.model.Vertex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphMatrixTest {
    private static final Logger logger = LoggerFactory.getLogger(GraphMatrixTest.class);

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

        matrix.addVertex(vertex1)
                .addVertex(vertex2)
                .addVertex(vertex3)
                .addVertex(vertex4);

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

        Assert.assertEquals(path.size(), 4);

        Edge firstEdge = path.get(0);
        Assert.assertEquals(firstEdge.getFrom(), vertex1);
        Assert.assertEquals(firstEdge.getTo(), vertex2);

        Edge lastEdge= path.get(3);
        Assert.assertEquals(lastEdge.getFrom(), vertex6);
        Assert.assertEquals(lastEdge.getTo(), vertex7);
    }

    @Test
    public void differentTypes(){
        GraphMatrix matrix = new DirectedGraphMatrix();
        Vertex vertex1 = new Vertex(new BigInteger("1"));
        Vertex vertex2 = new Vertex("Vertex 2");
        Vertex vertex3 = new Vertex("Vertex 3");
        Vertex vertex4 = new Vertex(new TestClass("Vertex 4"));

        matrix.addVertex(vertex1)
              .addVertex(vertex2)
              .addVertex(vertex3)
              .addVertex(vertex4);

        matrix.addEdge(vertex1, vertex2);
        matrix.addEdge(vertex1, vertex3);
        matrix.addEdge(vertex2, vertex4);
        matrix.addEdge(vertex3, vertex4);

        List<Edge> path = matrix.getPath(vertex1, vertex4);

        Assert.assertEquals(path.size(), 2);
        Edge first = path.get(0);
        Edge last = path.get(1);
        Assert.assertEquals(first.getFrom(), vertex1);
        Assert.assertEquals(first.getTo(), last.getFrom());
        Assert.assertEquals(last.getTo().toString(), vertex4.toString());
    }

    private class TestClass {
        private String label;

        public TestClass(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Test Class : " + label;
        }
    }
}
