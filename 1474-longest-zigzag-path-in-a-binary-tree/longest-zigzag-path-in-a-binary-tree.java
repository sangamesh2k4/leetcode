/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max=0;
    int[] dfs(TreeNode root){
        if (root == null) {
            return new int[]{-1, -1};
            }
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int leftStart=1+left[1];
        int rightStart=1+right[0];
        max = Math.max(max, Math.max(leftStart, rightStart));
        return new int[]{leftStart,rightStart};
    }
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max;
    }
}