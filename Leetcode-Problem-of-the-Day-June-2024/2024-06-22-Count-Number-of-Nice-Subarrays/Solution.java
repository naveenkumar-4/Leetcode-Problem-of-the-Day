public class Solution {
    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int currCount = 0, totCount = 0;
        while (right < n) {
            if (nums[right] % 2 == 1) {
                k--;
                currCount = 0;
            }
            while (k == 0) {
                currCount++;
                k += (nums[left++] % 2);
            }
            totCount += currCount;
            right++;
        }
        return totCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;
        int res = numberOfSubarrays(nums, k);
        System.err.println(res);
    }
}