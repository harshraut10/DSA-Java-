import java.util.*;

public class D {

    private static final int Infinity = Integer.MAX_VALUE;

    public void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];
        int[] distances = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            distances[i] = Infinity;
        }

        distances[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int minVertex = minDistance(distances, visited);
            visited[minVertex] = true;

            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && graph[minVertex][j] != 0 &&
                        distances[minVertex] != Infinity &&
                        distances[minVertex] + graph[minVertex][j] < distances[j]) {
                    distances[j] = distances[minVertex] + graph[minVertex][j];
                }
            }
        }

        printSolution(distances);
    }

    private int minDistance(int[] distances, boolean[] visited) {
        int min = Infinity;
        int minIndex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] <= min) {
                min = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void printSolution(int[] distances) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        D dijkstraAlgorithm = new D();
        dijkstraAlgorithm.dijkstra(graph, 0);
    }
}
