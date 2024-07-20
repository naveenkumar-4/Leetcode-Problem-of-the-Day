import java.util.Arrays;

public class Solution {
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n=rowSum.length, m = colSum.length;
        int[][] res = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i]-=res[i][j];
                colSum[j]-=res[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rowSum = {5,7,10};
        int[] colSum = {8,6,8};
        int[][] res =restoreMatrix(rowSum, colSum);
        for(int[] r : res){
            System.out.println(Arrays.toString(r));
        }
    }
}