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
    int cameras=0;
        int NEEDS_CAMERA = 0;
         int HAS_CAMERA = 1;
         int COVERED = 2;
    int dfs(TreeNode root){
        if(root==null){
            return COVERED;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);

        if(left==NEEDS_CAMERA || right==NEEDS_CAMERA){
            cameras++;
            return HAS_CAMERA;
        }
        if(left==HAS_CAMERA || right==HAS_CAMERA){
            return COVERED;
        }
        return NEEDS_CAMERA;
    }
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==NEEDS_CAMERA){
            cameras++;
        }
        return cameras;
    }
}