import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(String word : words){
            if(res.length() > 0){
                res.append(" ");
            }
            res.append(findRoot(word, dict));
        }

        return res.toString();

    }

    private static String findRoot(String word, Set<String> dict){
        for(int i=1; i<=word.length(); i++){
            String prefix = word.substring(0, i);
            if(dict.contains(prefix)){
                return prefix;
            }
        }
        return word;
    }

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String res = replaceWords(dictionary, sentence);
        System.err.println(res);
    }
}