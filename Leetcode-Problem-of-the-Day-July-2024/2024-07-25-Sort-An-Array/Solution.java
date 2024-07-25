import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] sortAnArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = nums[0], max = nums[0];
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int index = 0;
        for (int i = min; i <= max; i++) {
            while (map.getOrDefault(i, 0) > 0) {
                nums[index++] = i;
                map.put(i, map.get(i) - 1);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 1, 2, 0, 0 };
        nums = sortAnArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
