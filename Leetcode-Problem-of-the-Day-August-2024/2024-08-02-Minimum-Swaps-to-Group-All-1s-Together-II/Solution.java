public class Solution {
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int count1 = 0, count0 = 0;
        for (int i : nums) {
            if (i == 1)
                count1++;
        }

        int windowSize = count1;
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 0)
                count0++;
        }

        int minSwaps = count0;

        for (int i = windowSize; i < windowSize + n; i++) {
            if (nums[i % n] == 0)
                count0++;
            if (nums[i - windowSize] == 0)
                count0--;
            minSwaps = Math.min(minSwaps, count0);
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(minSwaps(nums));
    }
}