public class Solution{
    public static int heightChecker(int[] heights){
        int n = heights.length;
        int res = 0;
        int count[] = new int[101];
        for(int height : heights){
            count[height]++;
        }

        int currHeight = 0;
        for(int i=0; i<n; i++){
            while(currHeight < count.length && count[currHeight] == 0){
                currHeight++;
            }
            if(heights[i] != currHeight){
                res++;
            }
            count[currHeight]--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        int res = heightChecker(heights);
        System.out.println(res);;
    }
}