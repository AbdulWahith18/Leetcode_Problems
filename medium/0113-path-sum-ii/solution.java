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

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> l = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null)
            return res;

        l.add(root.val);

        if (root.left == null && root.right == null) {

            if (targetSum == root.val) {
                res.add(new ArrayList<>(l));
            }

        } else {

            pathSum(root.left, targetSum - root.val);
            pathSum(root.right, targetSum - root.val);
        }

        l.remove(l.size() - 1);

        return res;
    }
}