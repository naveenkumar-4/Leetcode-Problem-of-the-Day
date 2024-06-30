public class Solution {
    private static int findMin(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        for (int i : bloomDay) {
            min = Math.min(min, i);
        }
        return min;
    }

    private static int findMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            max = Math.max(max, i);
        }
        return max;
    }

    private static boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int noOfBouq = 0;
        int n = bloomDay.length;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                noOfBouq += count / k;
                count = 0;
            }
        }
        noOfBouq += count / k;
        return noOfBouq >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (m * k))
            return -1;
        int ans = -1;
        int low = findMin(bloomDay), high = findMax(bloomDay);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        int minDays = minDays(bloomDay, m, k);
        System.err.println(minDays);
    }
}