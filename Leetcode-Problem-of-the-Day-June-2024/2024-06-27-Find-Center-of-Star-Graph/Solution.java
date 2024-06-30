class Solution {
    public static int findCenter(int[][] edges) {
        int x = edges[0][0];
        int y = edges[0][1];
        if (x == edges[1][0] || x == edges[1][1]) {
            return x;
        }
        return y;
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 2 } };
        int center = findCenter(edges);
        System.out.println(center);
    }
}