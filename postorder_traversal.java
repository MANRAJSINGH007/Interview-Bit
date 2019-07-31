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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        
        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> temp=new Stack<>();
        stack.push(root);
        
        while(stack.size()>0){
            TreeNode curr_node=stack.pop();
            temp.push(curr_node.val);
            if(curr_node.left!=null){
                stack.push(curr_node.left);
            }
            if(curr_node.right!=null){
                stack.push(curr_node.right);
            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        while(temp.size()>0){
            ans.add(temp.pop());
        }
        
        return ans;
    }
}
