import java.util.HashMap;

public class Solution {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int pSum = 0;
        for (int i = 0; i < n; i++) {
            pSum += nums[i];

            int remainder = k == 0 ? pSum : pSum % k;
            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        boolean res = checkSubarraySum(nums, k);
        System.out.println(res);

    }
}