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
    List<Integer> leaves = new ArrayList<>();

    void collect(TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        collect(root.left);
        collect(root.right);
    }

    int index = 0;

    boolean check(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            if (index >= leaves.size()) {
                return false;
            }
            if (root.val != leaves.get(index)) {
                return false;
            }
            index++;
            return true;
        }
        boolean left = check(root.left);
        boolean right = check(root.right);
        return left&&right;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        collect(root1);
        boolean matched=check(root2);
        return matched&&index==leaves.size();

    }
}