import java.util.Arrays;

class Solution {
    private static boolean canWePlace(int[] position, int dist, int balls){
        int n = position.length;
        int countBalls = 1, lastBall = position[0];
        for(int i = 1; i<n; i++){
            if(position[i] - lastBall >= dist){
                countBalls++;
                lastBall = position[i];
            }
            if(countBalls >= balls){
                return true;
            }
        }
        return false;
    }
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 0, high = position[n-1] - position[0];
        while(low <= high){
            int mid = (low+high)/2;
            if(canWePlace(position, mid, m) == true){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        int minForce = maxDistance(position, m);
        System.out.println(minForce);
    }
}