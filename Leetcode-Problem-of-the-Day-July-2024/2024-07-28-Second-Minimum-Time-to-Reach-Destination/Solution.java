import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int dist1[] = new int[n + 1];
        int dist2[] = new int[n + 2];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { 1, 0 });
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int node = pair[0];
            int dist = pair[1];
            if (node == n && dist2[n] != Integer.MAX_VALUE) {
                return dist2[n];
            }
            if ((dist / change) % 2 == 1) {
                dist = ((dist / change) + 1) * change;
            }
            dist += time;
            for (Integer nbr : adjList.get(node)) {
                if (dist < dist1[nbr]) {
                    dist2[nbr] = dist1[nbr];
                    dist1[nbr] = dist;
                    pq.add(new int[] { nbr, dist });
                } else if (dist < dist2[nbr] && dist > dist1[nbr]) {
                    dist2[nbr] = dist;
                    pq.add(new int[] { nbr, dist });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 }, { 4, 5 } };
        int time = 3;
        int change = 5;
        int secondMin = secondMinimum(n, edges, time, change);
        System.out.println(secondMin);
    }
}