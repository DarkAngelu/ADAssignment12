class GraphAdjacencyMatrix {
    private int vertices;
    private int[][] adjacencyMatrix;

    public GraphAdjacencyMatrix(int v) {
        vertices = v;
        adjacencyMatrix = new int[v][v];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // Uncomment if undirected graph
    }

    public void displayGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class A12Q4 {
    public static void main(String args[]) {
        int numOfVertices = 4;
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(numOfVertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.displayGraph();
    }
}
