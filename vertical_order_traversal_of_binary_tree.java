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
    int y;
    int val;
    
    Pair(int y, int val){
        this.y=y;
        this.val=val;
    }
}
public class Solution {
    
    static int min=Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;
    
    public static void func(TreeNode root, int x, int y, HashMap<Integer,ArrayList<Pair>> map){
        
        if(root==null){
            return ;
        }
        
        min=Math.min(min,x);
        max=Math.max(max,x);

        if(!map.containsKey(x)){
            ArrayList<Pair> list=new ArrayList<>();
            list.add(new Pair(y,root.val));
            map.put(x,list);
        }
        
        else{
            ArrayList<Pair> list=map.get(x);
            int n=list.size();
            int index=-1;
            for(int i=n-1;i>=0;i--){
                if(list.get(i).y<=y){
                    index=i;
                    break;
                }
            }
            
            if(index==n-1){
                list.add(new Pair(y,root.val));
            }
            
            else if(index==-1){
                list.add(0,new Pair(y,root.val));
            }
            
            else{
                list.add(index+1,new Pair(y,root.val));
            }
        }
        
        
        func(root.left,x-1,y+1,map);
        func(root.right,x+1,y+1,map);
        
    }
    
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
        HashMap<Integer,ArrayList<Pair>> map=new HashMap<>();
        func(root,0,0,map);
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=min;i<=max;i++){
            ArrayList<Pair> temp=map.get(i);
            ArrayList<Integer> nodes=new ArrayList<>();
            for(int k=0;k<temp.size();k++){
                nodes.add(temp.get(k).val);
            }
            ans.add(nodes);
        }
        
        return ans;
    }
}
