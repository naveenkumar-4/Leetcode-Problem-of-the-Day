import java.util.Arrays;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0, k = 0;
        int n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);

    }

    public static void main(String[] args) {
        int nums1[] = { 4, 9, 5 };
        int nums2[] = { 9, 4, 9, 8, 4 };
        int res[] = intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}