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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return maxDepthR(root, 0);
    }

    public int maxDepthR(TreeNode root, int cnt){
        if(root == null){
            return 0;
        }

        int l =  maxDepthR(root.left, cnt);
        int r = maxDepthR(root.right, cnt);

        return 1 + Math.max(l, r);

    }
}
