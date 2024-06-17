public class Solution {
    public static int minPatches(int[] nums, int n) {
        long miss = 1;
        int result = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,10};
        int n = 6;
        int res = minPatches(nums, n);
        System.err.println(res);
    }
}