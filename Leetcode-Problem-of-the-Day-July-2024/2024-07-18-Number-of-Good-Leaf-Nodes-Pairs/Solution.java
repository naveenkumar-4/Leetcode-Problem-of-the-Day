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
    static private int res = 0;

    private static int[] dfs(TreeNode node, int distance) {
        int[] map = new int[11];

        if (node == null)
            return map;

        if (node.left == null && node.right == null)
            map[1] = 1;

        int[] left = dfs(node.left, distance);
        int[] right = dfs(node.right, distance);

        for (int i = 1; i < distance; i++)
            for (int j = 1; j <= distance - i; j++)
                res += (left[i] * right[j]);

        for (int i = 2; i < 11; i++)
            map[i] += left[i - 1] + right[i - 1];

        return map;
    }

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    public static void main(String[] args) {
        // Create the tree nodes
        // arr[] = [1,2,3,null,4]
        // TreeNode node7 = new TreeNode(7);
        // TreeNode node4 = new TreeNode(4);
        // TreeNode node2 = new TreeNode(2, node7, null);
        // TreeNode node6 = new TreeNode(6);
        // TreeNode node5 = new TreeNode(5, node6, null);
        // TreeNode node3 = new TreeNode(3, node5, node4);
        // TreeNode root = new TreeNode(1, node2, node3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, null, node4);
        TreeNode node3 = new TreeNode(3); 
        TreeNode root = new TreeNode(1, node2, node3);

        // Create a solution instance
        Solution solution = new Solution();

        // Specify the distance
        int distance = 3;

        // Find the number of pairs
        int result = solution.countPairs(root, distance);

        // Print the result
        System.out.println("Number of pairs: " + result);
    }
}