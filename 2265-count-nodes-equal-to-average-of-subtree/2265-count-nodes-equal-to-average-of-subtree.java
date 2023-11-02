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

    static void sum(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return;
        arr.set(0,arr.get(0)+root.val);
        arr.set(1,arr.get(1)+1);

        sum(root.left,arr);
        sum(root.right,arr);
    }

    static void helper(TreeNode root, ArrayList<Integer> ans){
        if(root==null) return;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(0);
        sum(root,arr);
        int avg = arr.get(0)/arr.get(1);

        if(root.val==avg) ans.set(0,ans.get(0)+1);

        helper(root.left,ans);
        helper(root.right,ans);
    }
    public int averageOfSubtree(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);

        helper(root,ans);
        return ans.get(0);
    }
}