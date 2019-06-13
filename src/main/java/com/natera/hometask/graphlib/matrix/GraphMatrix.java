package com.natera.hometask.graphlib.matrix;

import com.natera.hometask.graphlib.model.Edge;
import com.natera.hometask.graphlib.model.Vertex;

import java.util.*;

/**
 * Simple Graph lib:
 *
 * Should support 2 types of graphs - directed and undirected with 3 operations:
 *
 * addVertex - adds vertex to the graph
 *
 * addEdge - adds edge to the graph
 *
 * getPath - returns a list of edges between 2 vertices (path doesn’t have to be optimal)
 *
 * Vertices should be of a user defined type.
 *
 * Questions to be ready to answer (don’t have to implement):
 *
 * Add weighted edges support in your lib.
 * Add traverse function that will take a user defined function and apply it on every vertex of the graph.
 * Make you graphs thread safe.
 *
 * При возникновении следующих вопросов :
 * Нужно ли реализовывать базу данных для графов , нужны ли тесты, tdd?
 *
 * Ответы следующие:
 * Базу не нужно, а вот тесты желательны, но на самом деле на усмотрение кандидата
 * Наличие тестов мы смотрим, просто если тестов не будет, то на собеседовании мы будем про это спрашивать )
 *
 * Если будут возникать вопросы по тестовому - пожалуйста, задавайте.
 * Дедлайн по выполнению – неделя. Если за неделю по каким-то объективным причинам не получается сделать – дайте мне знать плиз.
 *
 * Параллельно предлагаю сразу назначить техническое интервью. В данный момент из ближайших дат 17,18,21 июня. Желательно в промежутке с 11:00 до 17:00 включительно. Когда вам было бы удобно?
 *
 * Раскрыть сообщение пользователя Anna Sycheva
 */


public abstract class GraphMatrix {
    public HashMap<Vertex, List<Vertex>> matrix = new HashMap<>();

    public void addVertex(Vertex vertex){
        List<Vertex> vertexes = matrix.get(vertex);
        if(vertexes != null) throw new IllegalArgumentException();

        matrix.put(vertex, new LinkedList<>());
    }

    public abstract void addEdge(Vertex from, Vertex to);

    public List<Edge> getPath(Vertex from, Vertex to){
        HashMap<Vertex, Vertex> direction = buildRoad(from);
        LinkedList<Edge> result           = new LinkedList();
        Vertex current = to;

        do{
            Vertex sourceVertex = direction.get(current);
            if(sourceVertex == null) break;

            result.addFirst(new Edge(sourceVertex, current));
            current = sourceVertex;
        } while(direction.size() != 0);

        return result;
    }

    private HashMap buildRoad(Vertex from){
        LinkedList<Vertex> queue     = new LinkedList<>();
        HashMap<Vertex, Vertex> road = new HashMap<>();
        Set<Vertex> visited          = new HashSet<>();

        queue.addFirst(from);
        visited.add(from);

        do{
            Vertex current = queue.removeFirst();
            List<Vertex> neighbors = matrix.get(current);

            for(Vertex neighbor: neighbors) {
                if(!visited.contains(neighbor)){
                    road.putIfAbsent(neighbor, current);
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        } while(queue.size() != 0);

        return road;
    }
}
