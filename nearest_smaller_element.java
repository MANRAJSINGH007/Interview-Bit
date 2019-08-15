public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> list) {
        
        if(list==null || list.size()==0){
            return new ArrayList<>();
        }
        
        int n=list.size();
        
        Stack<Integer> stack=new Stack<>();
        
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(-1);
        stack.push(list.get(0));
        
        for(int i=1;i<n;i++){
            
            int curr=list.get(i);
            if(stack.size()==0){
                stack.push(curr);
                ans.add(-1);
            }
            
            else{
                while(stack.size()>0 && stack.peek()>=curr){
                    stack.pop();
                }
                
                if(stack.size()==0){
                    ans.add(-1);
                }
                
                else{
                    ans.add(stack.peek());
                }
                
                stack.push(curr);
            }
            
        }
        
        return ans;
        
    }
}
