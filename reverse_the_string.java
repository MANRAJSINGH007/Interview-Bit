public class Solution {
    public String reverseWords(String a) {
        
        if(a==null || a.length()==0){
            return a;
        }
        
        char ch[]=a.toCharArray();
        int n=ch.length;
        
        for(int i=0;i<n/2;i++){
            
            char curr=ch[i];
            ch[i]=ch[n-1-i];
            ch[n-1-i]=curr;
            
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(ch[i]==' '){
                q.add(i);
            }
        }
        
        q.add(n);
        
        int curr=0;
        
        while(q.size()>1){
            
            int end=q.remove();
            
            int count=end-curr;
            
            for(int j=curr;j<(curr+count)/2;j++){
                char c=ch[j];
                ch[j]=ch[end-1-j+curr];
                ch[end-1-j+curr]=c;
            }
            
            curr=end+1;
            
        }
        
        String ans=new String(ch);
        return ans;
    }
}
