import java.util.HashSet;
public class Solution {
    public static int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int length=0;
        for(int i=0; i<n; i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }else{
                set.remove(s.charAt(i));
                length+=2;
            }
        }
        if(!set.isEmpty()){
            length+=1;
        }
        return length;
    }
    public static void main(String args[]){
        String s = "abccccdd";
        int length = longestPalindrome(s);
        System.err.println(length);
    }
}
