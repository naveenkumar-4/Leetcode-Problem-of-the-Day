import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    private static int getMappedValue(int num, int[] mapping) {
        String str = String.valueOf(num);
        StringBuilder s = new StringBuilder();
        for (char ch : str.toCharArray()) {
            int originalDigit = (char) (ch - '0');
            s.append(mapping[originalDigit]);
        }

        return Integer.parseInt(s.toString());
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mappedValues = new int[n][2];
        for (int i = 0; i < n; i++) {
            mappedValues[i][0] = nums[i];
            mappedValues[i][1] = getMappedValue(nums[i], mapping);
        }

        Arrays.sort(mappedValues, Comparator.comparingInt(a -> a[1]));

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = mappedValues[i][0];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] mapping = { 8, 9, 4, 0, 2, 1, 3, 5, 7, 6 };
        int nums[] = { 991, 338, 38 };
        nums = sortJumbled(mapping, nums);
        System.out.println(Arrays.toString(nums));
    }
}