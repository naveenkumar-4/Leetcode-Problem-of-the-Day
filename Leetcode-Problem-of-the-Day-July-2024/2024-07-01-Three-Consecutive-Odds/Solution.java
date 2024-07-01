public class Solution {
    public static boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 1) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 34, 3, 4, 5, 7, 23, 12 };
        boolean isExist = threeConsecutiveOdds(arr);
        System.out.println(isExist);
    }
}