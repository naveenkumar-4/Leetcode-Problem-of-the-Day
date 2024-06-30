import java.util.Arrays;

class Solution {
    public static long maximumImportance(int n, int[][] roads) {
        long degree[] = new long[n];
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }
        Arrays.sort(degree);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (degree[i] * (i + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] roads = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 2 }, { 1, 3 }, { 2, 4 } };
        long res = maximumImportance(n, roads);
        System.out.println(res);
    }
}