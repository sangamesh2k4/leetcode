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
    int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        
        int leftpath=0,rightpath=0;
        if(root.left!=null && root.left.val==root.val){
            leftpath=1+left;
        }
        else{
            leftpath=0;
        }
        if(root.right!=null && root.right.val==root.val){
            rightpath=1+right;
        }
        else{
            rightpath=0;
        }

        max=Math.max(max,leftpath+rightpath);
        return Math.max(leftpath,rightpath);
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }
}