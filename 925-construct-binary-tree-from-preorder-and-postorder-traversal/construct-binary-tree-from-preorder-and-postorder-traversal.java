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
    int[] preorder;
    int[] postorder;
    TreeNode build(int preStart ,int preEnd , int postStart,int postEnd){
        if(preStart>preEnd || postStart>postEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        if(preStart==preEnd){
            return root;
        }
        int index=0;
        for(int i=postStart;i<=postEnd;i++){
            if(postorder[i]==preorder[preStart+1]){
                index=i;
                break;
            }
        }
        int leftSize=index-postStart+1;
        root.left=build(preStart+1,preStart+leftSize,postStart,index);
        root.right=build(preStart+leftSize+1,preEnd,index+1,postEnd-1);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder=preorder;
        this.postorder=postorder;
        return build(0,preorder.length-1,0,postorder.length-1);
    }
}