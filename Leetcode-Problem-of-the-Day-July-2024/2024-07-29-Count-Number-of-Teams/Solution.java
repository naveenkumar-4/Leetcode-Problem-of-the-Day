public class Solution {
    public static int numTeams(int[] rating) {
        final int n = rating.length;
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            int[] L = new int[2];
            int[] R = new int[2];

            // Count ratings on the left of i
            for (int j = 0; j < i; j++)
                L[rating[j] < rating[i] ? 1 : 0]++;

            // Count ratings on the right of i
            for (int k = i + 1; k < n; k++)
                R[rating[k] < rating[i] ? 1 : 0]++;

            // number of valid teams
            cnt += L[0] * R[1] + L[1] * R[0];
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] rating = { 2, 5, 3, 4, 1 };
        int count = numTeams(rating);
        System.out.println(count);
    }
}