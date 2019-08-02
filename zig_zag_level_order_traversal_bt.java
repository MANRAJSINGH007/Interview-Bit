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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        stack1.push(root);
        
        while(stack1.size()>0 || stack2.size()>0){
            
            ArrayList<Integer> temp=new ArrayList<>();
            
            while(stack1.size()>0){
                
                TreeNode node = stack1.pop();
                temp.add(node.val);
                
                if(node.left!=null){
                    stack2.push(node.left);
                }
                
                if(node.right!=null){
                    stack2.push(node.right);
                }
                
            }
            
            if(temp.size()>0)
                ans.add(temp);
            
            temp=new ArrayList<>();
            
            while(stack2.size()>0){
                
                TreeNode node = stack2.pop();
                temp.add(node.val);
                
                if(node.right!=null){
                    stack1.push(node.right);
                }
                
                if(node.left!=null){
                    stack1.push(node.left);
                }
                
            }
            
            if(temp.size()>0)
                ans.add(temp);
            
            
        }
        
        return ans;
        
    }
}
