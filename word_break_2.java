public class Solution {
    
    public static ArrayList<String> func(String str, HashSet<String> set){
        
        int n=str.length();
        
        HashMap<Integer,ArrayList<String>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        
        for(int i=n-1;i>=0;i--){
            
            String temp="";
            
            for(int j=i;j<n;j++){
                
                temp+=str.charAt(j);
                
                if(set.contains(temp)){
                    
                    if(j==n-1){
                        ArrayList<String> curr=map.get(i);
                        curr.add(temp);
                    }
                    
                    else{
                        ArrayList<String> curr=map.get(i);
                        ArrayList<String> smaller_output=map.get(j+1);
                        if(smaller_output.size()>0){
                            for(int k=0;k<smaller_output.size();k++){
                                curr.add(temp+" "+smaller_output.get(k));
                            }
                        }
                    }
                    
                }
                
            }
            
        }
        
        ArrayList<String> answer=map.get(0);
        Collections.sort(answer);
        
        return answer;
        
    }
    
    
    public ArrayList<String> wordBreak(String str, ArrayList<String> list) {
        
        HashSet<String> set=new HashSet<>();
        
        for(int i=0;i<list.size();i++){
            set.add(list.get(i));
        }
        
        return func(str,set);
        
    }
}
