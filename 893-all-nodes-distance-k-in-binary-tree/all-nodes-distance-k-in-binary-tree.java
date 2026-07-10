/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
        HashMap<TreeNode,TreeNode> parentMap=new HashMap<>();
    void parentBuild(TreeNode root){
            if(root==null){
                return;
            }
            if(root.left!=null){
                parentMap.put(root.left,root);
            }
            if(root.right!=null){
                parentMap.put(root.right,root);
            }
            parentBuild(root.left);
            parentBuild(root.right);
        }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentBuild(root);
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty() && k > 0){
            int Size=q.size();
            for(int i=0;i<Size;i++){
                TreeNode curr=q.poll();
              if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
            }
            k--;
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}