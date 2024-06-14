public class Solution {
    private static int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static int minIncrementForUnique(int[] nums) {
        int moves = 0;
        int n = nums.length;
        int max = findMax(nums);
        int count[] = new int[max + n + 1];
        for (int i : nums) {
            count[i]++;
        }

        for(int i=0; i<count.length; i++){
            if(count[i] <= 1){
                continue;
            }
            int extra = count[i] - 1;
            count[i+1] += extra;
            moves += extra;
        }
        return moves;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,1,2,1,7};
        int minMoves = minIncrementForUnique(nums);
        System.err.println(minMoves);
    }
}
