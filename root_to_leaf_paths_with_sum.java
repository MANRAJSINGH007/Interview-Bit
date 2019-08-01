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
    
    static ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    
    public static void func(TreeNode root, int sum, ArrayList<Integer> list){
        
        if(root==null){
            return ;
        }
        
        if(root.left==null && root.right==null && sum==root.val){
            list.add(root.val);
            ArrayList<Integer> curr=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                curr.add(list.get(i));
            }
            
            ans.add(curr);
            list.remove(list.size()-1);
            return ;
        }
        
        list.add(root.val);
        func(root.left,sum-root.val,list);
        func(root.right,sum-root.val,list);
        
        list.remove(list.size()-1);
        
        return ;
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        
        if(root==null){
            return new ArrayList<>();
        }
        
        ans=new ArrayList<>();
        
        ArrayList<Integer> list=new ArrayList<>();
        
        func(root,sum,list);
        
        return ans;
        
    }
}
