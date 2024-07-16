import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<Integer, Boolean> hasParent = new HashMap<>();
        for (int[] description : descriptions) {
            int parentVal = description[0], childVal = description[1], isLeft = description[2];
            TreeNode parentNode = null, childNode = null;
            if (!map.containsKey(parentVal)) {
                parentNode = new TreeNode(parentVal);
                map.put(parentVal, parentNode);
            } else {
                parentNode = map.get(parentVal);
            }

            if (!map.containsKey(childVal)) {
                childNode = new TreeNode(childVal);
                map.put(childVal, childNode);
            } else {
                childNode = map.get(childVal);
            }

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            hasParent.put(childVal, true);
        }

        TreeNode root = null;
        for (int nodeval : map.keySet()) {
            if (!hasParent.containsKey(nodeval)) {
                root = map.get(nodeval);
                break;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[][] descriptions = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
        Solution solution = new Solution();
        TreeNode root = solution.createBinaryTree(descriptions);

        // Print the structure of the binary tree
        printTree(root, 0);
    }

    public static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.val);
        printTree(node.left, level + 1);
    }
}