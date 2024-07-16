public class Solution {
    public static int findTheWinner(int n, int k) {
        int result = 0;
        for (int num_player = 2; num_player <= n; ++num_player) {
            result = (result + k) % num_player;
        }
        return result + 1;
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        int winner = findTheWinner(n, k);
        System.out.println(winner);
    }
}