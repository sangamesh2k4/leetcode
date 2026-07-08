/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    void dfs(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;}
            sb.append(root.val).append(",");
            dfs(root.left,sb);
            dfs(root.right,sb);
        }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       StringBuilder sb=new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }
    TreeNode build(Queue<String> q){
        String val=q.poll();
        if(val.equals("N")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(val));
        root.left=build(q);
        root.right=build(q);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        Queue<String> q=new LinkedList<>();
        for(String s:arr){
            q.offer(s);
        }

        return build(q);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));