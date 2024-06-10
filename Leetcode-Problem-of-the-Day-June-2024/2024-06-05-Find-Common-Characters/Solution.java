import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static List<String> commonChars(String[] words) {
        int last[] = count(words[0]);

        for(int i = 1; i< words.length; i++){
            last = intersection(last, count(words[i]));
        }

        List<String> res = new ArrayList<>();
        for(int i=0; i<26; i++){
            if(last[i] != 0){
                char ch = (char)('a' + i);
                String s = String.valueOf(ch);
                while(last[i] > 0){
                    res.add(s);
                    last[i]--;
                }
            }
        }
        return res;


    }

    public static int[] count(String s){
        int n = s.length();
        int freq[] = new int[26];
        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }

        return freq;
    }

    public static int[] intersection(int[] a, int[] b){
        int res[] = new int[26];
        for(int i=0; i<26; i++){
            res[i] = Math.min(a[i], b[i]);
        }

        return res;
    }

    public static void main(String args[]){
        String words[] = {"bella","label","roller"};
        List<String> result = Solution.commonChars(words);
        System.out.println(result);
    }
}