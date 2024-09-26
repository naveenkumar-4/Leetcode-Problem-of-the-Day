import java.util.Arrays;

public class Solution {
    static class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            this.children = new TrieNode[26];
            this.count = 0;
        }
    }

    static TrieNode root;

    private static void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.count += 1;
        }
    }

    private static int getScore(String s) {
        TrieNode node = root;
        int count = 0;
        for (char c : s.toCharArray()) {
            node = node.children[c - 'a'];
            count += node.count;
        }
        return count;
    }

    public static void main(String[] args) {
        String words[] = { "abc", "ab", "bc", "b" };
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] = getScore(words[i]);
        }

        System.out.println(Arrays.toString(res));
    }
}