public class Solution {
    public static boolean judgeSquareSum(int c) {
        long a = 0, b = (int)Math.sqrt(c);
        while(a <= b){
            if(a*a + b*b == c){
                return true;
            }else if(a*a + b*b < c){
                a++;
            }else{
                b--;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int c = 5;
        boolean res = judgeSquareSum(c);
        System.err.println(res);
    }
}