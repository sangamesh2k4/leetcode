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
    int[] inorder;
    TreeNode build(int preStart,int preEnd,int inStart ,int inEnd){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int index=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==root.val){
                index=i;
                break;
            }
        }
        int leftSize=index-inStart;
    root.right = build(preStart + leftSize + 1,preEnd,index + 1,inEnd);
    root.left=build(preStart+1,preStart+leftSize,inStart,index-1);
    return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0,preorder.length - 1,0,inorder.length - 1);
    }
}