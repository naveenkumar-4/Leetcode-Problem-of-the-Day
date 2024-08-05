import java.util.Arrays;

public class Solution {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }

        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1], dist = edge[2];
            distance[node1][node2] = dist;
            distance[node2][node1] = dist;
        }

        for (int midle = 0; midle < n; midle++) {
            for (int source = 0; source < n; source++) {
                for (int destination = 0; destination < n; destination++) {
                    if (distance[source][midle] < Integer.MAX_VALUE
                            && distance[midle][destination] < Integer.MAX_VALUE) {
                        distance[source][destination] = Math.min(
                                distance[source][destination], distance[source][midle] + distance[midle][destination]);
                    }
                }
            }
        }

        int minimum_number = n;
        int res = -1;

        for (int source = 0; source < n; source++) {
            int source_count = 0;
            for (int destination = 0; destination < n; destination++) {
                if (distance[source][destination] <= distanceThreshold) {
                    source_count++;
                }
            }

            if (source_count <= minimum_number) {
                minimum_number = source_count;
                res = source;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        int distanceThreshold = 4;
        int distance = findTheCity(n, edges, distanceThreshold);
        System.out.println(distance);

    }
}