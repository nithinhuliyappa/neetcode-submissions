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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    //1,  2, Null, Null, 3, 4, Null, Null, 5, Null, Null
    public void preOrder(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");

        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    private int index;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        int index = 0;
        return buildTree(str);
    }

    public TreeNode buildTree(String[] str){
        String val = str[index++];

        if(val.equals("null")){
            return null;
        }
           

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = buildTree(str);
        root.right = buildTree(str);

        return root;
    }
}
