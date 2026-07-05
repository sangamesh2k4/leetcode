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
    List<List<Integer>> answer=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    void  helper(TreeNode root,int remainingsum,List <Integer>path){
        if(root==null){
            return;
        }
        path.add(root.val);
        remainingsum-=root.val;
        if(root.left==null && root.right==null && remainingsum==0){
            answer.add(new ArrayList<>(path));
        }
        helper(root.left,remainingsum,path);
        helper(root.right,remainingsum,path);
        path.remove(path.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum,path);
        return answer;
    }
}