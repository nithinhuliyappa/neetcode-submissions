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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> dp = new ArrayDeque<>();
        if (root != null)
            dp.add(root);

        while(!dp.isEmpty()){
            int size = dp.size();
            List<Integer> list = new ArrayList<>();
            while(size>0){
                TreeNode node = dp.poll();
                list.add(node.val);
                if(node.left != null)
                    dp.add(node.left);
                if(node.right != null)
                    dp.add(node.right);
                size--;
            }
            res.add(list);
        }
        return res;
    }
}
