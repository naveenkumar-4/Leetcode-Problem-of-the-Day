import java.util.Arrays;

public class Solution {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int count[] = new int[1001];
        int index = 0;
        for(int i : arr1){
            count[i]++;
        }
        int[]  res = new int[arr1.length];
        for(int i : arr2){
            while(count[i] > 0){
                res[index] = i;
                index++;
                count[i]--;
            }
        }
        // System.out.println(Arrays.toString(count));
        for(int i=0; i<=1000; i++){
            while(count[i] > 0) {
                res[index++] = i;
                count[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] res = relativeSortArray(arr1, arr2);
        System.err.println(Arrays.toString(res));
    }
}
