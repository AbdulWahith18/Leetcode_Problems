
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        }

        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) ||
               hasPathSum(root.right, targetSum);
 */
class Solution {
    }
}
