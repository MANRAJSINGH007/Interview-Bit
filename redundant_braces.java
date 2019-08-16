public class Solution {
    
    public int braces(String str) {
        
        if(str==null || str.equals("")){
            return 0;
        }
        
        int n=str.length();
        
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<n;i++){
            
            char curr=str.charAt(i);
            if(curr!=')'){
                stack.push(curr);
            }
            
            else{
                
                int flag=0;
                
                while(stack.size()>0 && stack.peek()!='('){
                    
                    char top=stack.peek();
                    if(top=='+' || top=='-' || top=='*' || top=='/'){
                        flag=1;
                    }
                    
                    stack.pop();
                }
                
                if(flag==0){
                    return 1;
                }
                
                stack.pop();
                
            }
            
        }
        
        return 0;
    }
}
