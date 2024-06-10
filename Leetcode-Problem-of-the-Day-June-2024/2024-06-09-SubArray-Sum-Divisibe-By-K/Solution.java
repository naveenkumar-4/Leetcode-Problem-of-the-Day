import java.util.HashMap;

public class Solution {
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];

            int remainder = sum % k;
            if(remainder < 0) remainder+=k;
            if(remainderMap.containsKey(remainder)){
                count+=remainderMap.get(remainder);
            }
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0)+1);
            
        }
        return count;
    }
    public static void main(String[] args) {
        int nums[] = {4,5,0,-2,-3,1};
        int k = 5;
        int subArrays = subarraysDivByK(nums, k);
        System.out.println(subArrays);
    }
}