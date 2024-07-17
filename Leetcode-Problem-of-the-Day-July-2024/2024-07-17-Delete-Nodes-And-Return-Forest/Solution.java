import java.util.List;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> to_delete_set = new HashSet<>();
        List<TreeNode> res = new ArrayList<>();
        for(int i:to_delete){
            to_delete_set.add(i);
        }
        dfs(root, true, to_delete_set, res);
        return res;
    }

    public static TreeNode dfs(TreeNode node, boolean is_root, Set<Integer> to_delete_set, List<TreeNode> res){
        if(node == null) return null;
        boolean deleted = to_delete_set.contains(node.val);
        if(is_root && !deleted) res.add(node);
        node.left = dfs(node.left, deleted, to_delete_set, res);
        node.right = dfs(node.right, deleted, to_delete_set, res);
        return deleted ? null : node;
    }

     public static void main(String[] args) {
        // Creating the tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        //       / \
        //      7   8
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5, node7, node8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode root = new TreeNode(1, node2, node3);

        int[] to_delete = {3, 5};

        // Calling the delNodes method
        List<TreeNode> result = Solution.delNodes(root, to_delete);

        // Printing the resulting forest
        for (TreeNode tree : result) {
            printTree(tree);
            System.out.println();
        }
    }

    // Helper method to print the tree in pre-order traversal
    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}