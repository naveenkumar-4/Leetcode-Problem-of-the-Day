// class Solution {
//     public int minKBitFlips(int[] nums, int k) {
//         int n = nums.length;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int times = 0;
//         int ans = 0;
//         for(int i=0; i<n; i++){
//             if(i >= k){
//                 times-=map.getOrDefault(i-k, 0);
//             }
//             if((nums[i] == 1 && times%2==1) || (nums[i] == 0 && times%2 == 0)){
//                 if(i+k > n){return -1;}
//                 times++;
//                 ans++;
//                 map.put(i, 1);
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public static int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int times = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (nums[i - k] > 1) {
                    nums[i - k] -= 2;
                    times--;
                }
            }
            if ((nums[i] == 1 && times % 2 == 1) || (nums[i] == 0 && times % 2 == 0)) {
                if (i + k > n)
                    return -1;
                times++;
                ans++;
                nums[i] += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };
        int k = 1;
        int res = minKBitFlips(nums, k);
        System.out.println(res);
    }
}