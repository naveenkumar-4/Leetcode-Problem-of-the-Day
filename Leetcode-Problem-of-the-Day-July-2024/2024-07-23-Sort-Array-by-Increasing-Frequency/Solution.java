import java.util.*;

class Solution {
    public static int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }

        Collections.sort(list, (a, b) -> {
            int freqCompare = mp.get(a).compareTo(mp.get(b));
            if (freqCompare == 0) {
                return b - a;
            }
            return freqCompare;
        });

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        nums = frequencySort(nums);
        System.out.println(Arrays.toString(nums));
    }
}