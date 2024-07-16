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
    public static TreeNode lca(TreeNode node, int p, int q) {
        if (node == null) return node;
        if (node.val == p || node.val == q) return node;
        TreeNode leftSide = lca(node.left, p, q);
        TreeNode rightSide = lca(node.right, p, q);
        if (leftSide != null && rightSide != null) return node;
        return leftSide != null ? leftSide : rightSide;
    }

    private boolean findPath(TreeNode node, int target, StringBuilder path) {
        if (node == null) return false;
        if (node.val == target) return true;
        path.append('L');
        if (findPath(node.left, target, path)) return true;
        path.setLength(path.length() - 1);  // backtrack
        path.append('R');
        if (findPath(node.right, target, path)) return true;
        path.setLength(path.length() - 1);  // backtrack
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lcaNode = lca(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToEnd = new StringBuilder();
        findPath(lcaNode, startValue, pathToStart);
        findPath(lcaNode, destValue, pathToEnd);

        // Replace all characters in pathToStart with 'U'
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) {
            result.append('U');
        }
        result.append(pathToEnd);

        return result.toString();
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Example: Find directions from node 2 to node 9
        int startValue = 2;
        int destValue = 9;

        Solution solution = new Solution();
        String directions = solution.getDirections(root, startValue, destValue);
        
        System.out.println("Directions from " + startValue + " to " + destValue + ": " + directions);
    }
}
