import java.util.*;

class GraphAdjacencyList {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public GraphAdjacencyList(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencyList[i] = new LinkedList();
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Uncomment for undirected graph
    }

    public void displayGraph() {
        for (int i = 0; i < vertices; ++i) {
            System.out.print(i + " : " + adjacencyList[i]);
            System.out.println();
        }
    }
}

public class A12Q5 {
    public static void main(String args[]) {
        int numOfVertices = 4;
        GraphAdjacencyList graph = new GraphAdjacencyList(numOfVertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.displayGraph();
    }
}
