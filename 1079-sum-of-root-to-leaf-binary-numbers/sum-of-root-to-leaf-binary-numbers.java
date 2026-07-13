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
    int current;
    int dfs(TreeNode root ,int current){
        if(root==null){
            return 0;
        }
        current=current*2+root.val;
        if(root.left==null && root.right==null){
            return current;
        }
        int left=dfs(root.left,current);
        int right=dfs(root.right,current);
        return left+right;
    }
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }
}