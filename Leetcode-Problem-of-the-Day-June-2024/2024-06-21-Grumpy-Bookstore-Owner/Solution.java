public class Solution {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int zeroSum = 0, maxWindowSum = 0, windowSum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                zeroSum += customers[i];
            }
            if (i < minutes) {
                windowSum += (grumpy[i] == 1 ? customers[i] : 0);
            } else {
                windowSum += (grumpy[i] == 1 ? customers[i] : 0)
                        - (grumpy[i - minutes] == 1 ? customers[i - minutes] : 0);
            }
            maxWindowSum = Math.max(maxWindowSum, windowSum);
        }
        return maxWindowSum + zeroSum;
    }

    public static void main(String[] args) {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;
        int res = maxSatisfied(customers, grumpy, minutes);
        System.err.println(res);
    }
}