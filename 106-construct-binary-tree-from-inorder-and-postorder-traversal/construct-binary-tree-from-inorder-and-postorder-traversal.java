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
    int[] inorder;
    int[] postorder;
    TreeNode build(int postStart ,int postEnd,int inStart,int inEnd){
        if(postStart>postEnd || inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postEnd]);
        int index=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==root.val){
                index=i;
                break;
            }
        }
        int leftSize=index-inStart;
        root.right=build(postStart+leftSize,postEnd-1,index+1,inEnd);
        root.left=build(postStart,postStart+leftSize-1,inStart,index-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        return build(0,postorder.length-1,0,inorder.length-1);
        
    }
}