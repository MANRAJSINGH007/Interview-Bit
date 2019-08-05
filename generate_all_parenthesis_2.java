public class Solution {
    
    public static ArrayList<String> func(int n, int opening, int closing){
        
        if(closing==n){
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        if(opening==n){
            
            int count=closing;
            String temp="";
            while(count!=n){
                temp+=")";
                count++;
            }
            
            ArrayList<String> ans=new ArrayList<>();
            ans.add(temp);
            return ans;
        }
        
        if(opening==closing){
            ArrayList<String> ans=new ArrayList<>();
            ArrayList<String> temp=func(n,opening+1,closing);
            if(temp.size()>0){
                for(int k=0;k<temp.size();k++){
                    String curr=temp.get(k);
                    ans.add("("+curr);
                }
            }
            
            return ans;
        }
        
        ArrayList<String> ans=new ArrayList<>();
        ArrayList<String> temp=func(n,opening+1,closing);
        if(temp.size()>0){
            for(int k=0;k<temp.size();k++){
                String curr=temp.get(k);
                ans.add("("+curr);
            }
        }
        
        temp=func(n,opening,closing+1);
        if(temp.size()>0){
            for(int k=0;k<temp.size();k++){
                String curr=temp.get(k);
                ans.add(")"+curr);
            }
        }
        
        return ans;
    }
    
    public ArrayList<String> generateParenthesis(int n) {
        
        ArrayList<String> ans=func(n,0,0);
        Collections.sort(ans);
        
        return ans;
    }
}
