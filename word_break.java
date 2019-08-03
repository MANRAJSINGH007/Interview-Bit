public class Solution {
    
    public static boolean func(String str, int i, HashSet<String> set, HashMap<Integer,Boolean> dp){
        
        if(i==str.length()){
            return true;
        }
        
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        
        String temp="";
        
        for(int j=i;j<str.length();j++){
            
            temp+=str.charAt(j);
            
            if(set.contains(temp)){
                
                if(func(str,j+1,set,dp)){
                    dp.put(i,true);
                    return true;
                }
            }
        }
        
        dp.put(i,false);
        return false;
        
        
    }
    
    public static boolean func2(String str, HashSet<String> set){
        
        int n=str.length();
        
        boolean dp[]=new boolean[n];
        
        for(int i=n-1;i>=0;i--){
            
            String temp="";
            
            for(int j=i;j<n;j++){
                
                temp+=str.charAt(j);
                
                if(set.contains(temp)){
                    
                    if(j==n-1){
                        dp[i]=true;
                        break;
                    }
                    
                    else{
                        if(dp[j+1]){
                            dp[i]=true;
                            break;
                        }
                    }
                }
            }
            
        }
        
        return dp[0];
        
    }
    
    public int wordBreak(String str, ArrayList<String> list) {
        
        HashSet<String> set=new HashSet<>();
        
        for(int i=0;i<list.size();i++){
            set.add(list.get(i));
        }
        
        
        if(func2(str,set)){
            return 1;
        }
        
        return 0;
        
    }
}
