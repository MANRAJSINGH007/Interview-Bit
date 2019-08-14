public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null){
            return 0;
        }
        
        int n=s.length();
        
        if(n<=1){
            return n;
        }
        
        HashMap<Character,Integer> map=new HashMap<>();
        int max=1;
        
        int start=0;
        map.put(s.charAt(0),0);
        
        int end=1;
        
        while(end<n){
            
            char curr=s.charAt(end);
            if(!map.containsKey(curr)){
                map.put(curr,end);
                max=Math.max(max,end-start+1);
                end++;
            }
            
            else if(map.get(curr)<start){
                map.put(curr,end);
                max=Math.max(max,end-start+1);
                end++;
            }
            
            else{
                start=map.get(curr)+1;
                map.put(curr,end);
                max=Math.max(max,end-start+1);
                end++;
            }
            
        }
        
        return max;
        
        
    }
}
