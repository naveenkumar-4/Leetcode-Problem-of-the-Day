import java.util.*;

public class Solution {
    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> mp = new HashMap<>();
        int count = 0;
        for (String str : arr) {
            mp.put(str, mp.getOrDefault(str, 0) + 1);
        }

        for (String str : arr) {
            if (mp.get(str) == 1) {
                count++;
                if (count == k) {
                    return str;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] arr = { "d", "b", "c", "b", "c", "a" };
        int k = 2;
        String ele = kthDistinct(arr, k);
        System.out.println(ele);
    }
}