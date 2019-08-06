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
class Pair{
    int max1=Integer.MIN_VALUE;
    int max2=Integer.MIN_VALUE;
    
    Pair(int max1, int max2){
        this.max1=max1;
        this.max2=max2;
    }
    
} 
 
public class Solution {
    
    static HashMap<TreeNode,Pair> map=new HashMap<>();
    
    public static int func(TreeNode root, int flag){
        
        if(root==null){
            return Integer.MIN_VALUE;
        }
        
        if(map.containsKey(root)){
            Pair obj=map.get(root);
            if(flag==0){
                if(obj.max1!=Integer.MIN_VALUE){
                    return obj.max1;
                }
            }
            else{
                if(obj.max2!=Integer.MIN_VALUE){
                    return obj.max2;
                }
            }
        }
        
        if(flag==0){
            
            int x1=func(root.left,0);
            int x2=func(root.right,0);
            
            int max=Math.max(x1,x2);
            
            int x3=func(root.left,1);
            int x4=func(root.right,1);
            
            if(x3!=Integer.MIN_VALUE && x4!=Integer.MIN_VALUE)
                max=Math.max(max,x3+x4+root.val);
                
            if(x3!=Integer.MIN_VALUE)
                max=Math.max(max,x3+root.val);
                
            if(x4!=Integer.MIN_VALUE)
                max=Math.max(max,x4+root.val);
            
            max=Math.max(max,root.val);
            
            if(map.containsKey(root)){
                
                Pair obj=map.get(root);
                obj.max1=max;
                map.put(root,obj);
            }
            
            else{
               Pair obj=new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);
               obj.max1=max;
               map.put(root,obj);
            }
            
            return max;
            
        }
        
        else{
            
            int x1=func(root.left,1);
            int x2=func(root.right,1);
            
            int max=Integer.MIN_VALUE;
            
            max=Math.max(max,root.val);
            
            if(x1!=Integer.MIN_VALUE)
                max=Math.max(root.val+x1,max);
                
            if(x2!=Integer.MIN_VALUE)
            max=Math.max(root.val+x2,max);
            
            if(map.containsKey(root)){
                
                Pair obj=map.get(root);
                obj.max2=max;
                map.put(root,obj);
            }
            
            else{
               Pair obj=new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);
               obj.max2=max;
               map.put(root,obj);
            }
            
            return max;
            
        }
        
        
    }
    
    public int maxPathSum(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        map=new HashMap<>();
        
        return func(root,0);
    }
}
