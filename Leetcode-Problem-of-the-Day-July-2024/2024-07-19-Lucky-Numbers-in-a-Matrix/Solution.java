import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            int minEle = matrix[i][0];
            int index = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < minEle) {
                    minEle = matrix[i][j];
                    index = j;
                }
            }

            int maxEle = matrix[0][index];
            for (int k = 1; k < rows; k++) {
                if (matrix[k][index] > maxEle) {
                    maxEle = matrix[k][index];
                }
            }

            if (minEle == maxEle) {
                res.add(maxEle);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
        List<Integer> res = luckyNumbers(matrix);
        System.out.println(res);
    }
}