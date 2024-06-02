import java.util.Arrays;

public class Main{
    public static void reverseString(char[] s){
        int n = s.length;
        int start = 0, end = n-1;
        while(start <= end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]){
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}