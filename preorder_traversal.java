/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        
        ArrayList<Integer> list=new ArrayList<>();
        
        while(stack.size()>0){
            TreeNode curr=stack.pop();
            list.add(curr.val);
            if(curr.right!=null){
                stack.push(curr.right);
            }
            if(curr.left!=null){
                stack.push(curr.left);
            }
        }
        
        return list;
        
        
    }
}
