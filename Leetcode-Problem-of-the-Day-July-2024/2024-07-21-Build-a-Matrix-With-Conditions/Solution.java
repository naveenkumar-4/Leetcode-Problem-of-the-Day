import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public static ArrayList<ArrayList<Integer>> buildGraph(int k, int[][] mat) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < mat.length; i++) {
            list.get(mat[i][0]).add(mat[i][1]);
        }
        return list;
    }

    public static ArrayList<Integer> topoSort(int k, ArrayList<ArrayList<Integer>> list) {
        int indegree[] = new int[k + 1];
        for (int i = 0; i < list.size(); i++) {
            for (int child : list.get(i)) {
                indegree[child]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int val = q.poll();
            topo.add(val);
            for (Integer i : list.get(val)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        if (topo.size() != k) {
            return new ArrayList<Integer>();
        }
        return topo;
    }

    public static void filltheRemaining(ArrayList<Integer> topo, int k) {
        int visited[] = new int[k + 1];
        for (int i = 0; i < topo.size(); i++) {
            visited[topo.get(i)]++;
        }
        for (int i = 1; i <= k; i++) {
            if (visited[i] == 0) {
                topo.add(i);
            }
        }
    }

    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<ArrayList<Integer>> adjList1 = buildGraph(k, rowConditions);
        ArrayList<ArrayList<Integer>> adjList2 = buildGraph(k, colConditions);

        ArrayList<Integer> topo1 = topoSort(k, adjList1);
        ArrayList<Integer> topo2 = topoSort(k, adjList2);
        if (topo1.size() == 0 || topo2.size() == 0) {
            return new int[0][0];
        }

        filltheRemaining(topo1, k);
        filltheRemaining(topo2, k);

        int[][] ans = new int[k][k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < topo2.size(); i++) {
            map.put(topo2.get(i), i);
        }
        for (int i = 0; i < topo1.size(); i++) {
            ans[i][map.get(topo1.get(i))] = topo1.get(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        // k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
        int k = 3;
        int[][] rowConditions = { { 1, 2 }, { 3, 2 } }, colConditions = { { 2, 1 }, { 3, 2 } };
        int[][] res = buildMatrix(k, rowConditions, colConditions);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }
}