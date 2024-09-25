public class Solution {

    static class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[10];
        }
    }

    static TrieNode root;

    private static void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - '0'] == null) {
                node.children[c - '0'] = new TrieNode();
            }
            node = node.children[c - '0'];
        }
    }

    private static int search(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.children[c - '0'] == null) {
                return i;
            }
            node = node.children[c - '0'];
        }

        return s.length();
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new TrieNode();
        for (int i : arr1) {
            insert(String.valueOf(i));
        }
        int max = 0;
        for (int i : arr2) {
            max = Math.max(max, search(String.valueOf(i)));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 10, 100 };
        int[] arr2 = { 1000 };
        int longestCommonPrefix = longestCommonPrefix(arr1, arr2);
        System.out.println(longestCommonPrefix);
    }
}