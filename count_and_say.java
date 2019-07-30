public class Solution {
    public String countAndSay(int n) {
        
        String read="1";
        int i=1;
        
        while(i!=n){
            
            int size=read.length();
            int count=1;
            char curr_char=read.charAt(0);
            int index=1;
            String ans="";
            if(index==size){
                ans+=Integer.toString(count)+curr_char;
            }
            
            while(index<size){
                
                while(index<size && read.charAt(index)==curr_char){
                    count++;
                    index++;
                }
                
                ans+=Integer.toString(count)+curr_char;
                
                if(index==size){
                    break;
                }
                
                curr_char=read.charAt(index);
                count=1;
                index++;
                if(index==size){
                    ans+=Integer.toString(count)+curr_char;
                }
                
            }
            
            
            read=ans;
            i++;
        }
        
        return read;
        
    }
}
