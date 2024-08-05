import java.util.Arrays;

public class Solution {
    public static int rangeSum(int[] nums, int n, int left, int right) {
        int start = 0, end = 0;
        int[] sums = new int[n * (n + 1) / 2];
        int index = 0;
        while (start < n) {
            end = start;
            int sum = 0;
            while (end < n) {
                sum += nums[end];
                sums[index++] = sum;
                end++;
            }
            start++;
        }
        Arrays.sort(sums);
        int sum = 0;
        int mod = (int) (1e9 + 7);
        for (int i = left - 1; i < right; ++i) {
            sum = (sum + sums[i]) % mod;
        }
        System.out.println(Arrays.toString(sums));
        return sum % mod;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int n = 4;
        int left = 1;
        int right = 5;
        int sum = rangeSum(nums, n, left, right);
        System.out.println(sum);
    }
}
