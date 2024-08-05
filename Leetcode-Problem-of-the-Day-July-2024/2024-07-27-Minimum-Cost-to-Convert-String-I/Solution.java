import java.util.Arrays;

public class Solution {
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long dist[][] = new long[26][26];
        int n = original.length;
        for (long[] i : dist) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        for (int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int wt = cost[i];
            dist[u][v] = Math.min(dist[u][v], wt);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (i == j)
                        continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i))
                continue;
            if (dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'] >= Integer.MAX_VALUE)
                return -1;
            ans += dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }
        return ans;
    }

    public static void main(String[] args) {
        String source = "abcd";
        String target = "acbe";
        char[] original = { 'a', 'b', 'c', 'c', 'e', 'd' };
        char[] changed = { 'b', 'c', 'b', 'e', 'b', 'e' };
        int[] cost = { 2, 5, 5, 1, 2, 20 };
        long minCost = minimumCost(source, target, original, changed, cost);
        System.out.println(minCost);

    }
}