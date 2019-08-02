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
    
    static boolean ans=false;
    
    public static void func(TreeNode root, int x, HashSet<Integer> set){
        
        if(root==null){
            return ;
        }
        
        
        if(ans){
            return ;
        }
        
        if(root.val>=x){
            func(root.left,x,set);
            return ;
        }
        
        else{
            
            if(set.contains(x-root.val)){
                ans=true;
                return ;
            }
            
            set.add(root.val);
            func(root.left,x,set);
            if(ans){
                return ;
            }
            
            func(root.right,x,set);
            return ;
            
        }
        
        
    }
    
    public int t2Sum(TreeNode root, int x) {
        
        if(root==null){
            return 0;
        }
        
        HashSet<Integer> set=new HashSet<>();
        ans=false;
        
        func(root,x,set);
        
        if(ans){
            return 1;
        }
        
        return 0;
        
    }
}
