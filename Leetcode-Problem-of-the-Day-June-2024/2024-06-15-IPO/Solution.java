import java.util.PriorityQueue;

public class Solution {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> profitsPQ = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < profits.length; i++) {
            if (capital[i] <= w) {
                profitsPQ.add(profits[i]);
            } else {
                pq.add(new int[] { capital[i], profits[i] });
            }
        }

        while (k > 0) {
            if (profitsPQ.isEmpty()) {
                break;
            }
            w += profitsPQ.poll();
            while (!pq.isEmpty() && w >= pq.peek()[0]) {
                profitsPQ.add(pq.poll()[1]);
            }
            k--;
        }
        return w;

    }

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        int res = findMaximizedCapital(k, w, profits, capital);
        System.err.println(res);
    }
}