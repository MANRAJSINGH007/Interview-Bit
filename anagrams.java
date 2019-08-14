public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> s) {
        
        if(s==null || s.size()==0){
            return new ArrayList<>();
        }
        
        HashMap<String,ArrayList<Integer>> map=new HashMap<>();
        
        int n=s.size();
        
        for(int i=0;i<n;i++){
            
            String curr=s.get(i);
            int arr[]=new int[26];
            for(int j=0;j<curr.length();j++){
                arr[(int)curr.charAt(j)-97]++;
            }
            
            String temp="";
            for(int j=0;j<26;j++){
                temp+=Integer.toString(arr[j]);
            }
            
            if(map.containsKey(temp)){
                ArrayList<Integer> list=map.get(temp);
                list.add(i+1);
            }
            
            else{
                ArrayList<Integer> list=new ArrayList<>();
                list.add(i+1);
                map.put(temp,list);
            }
            
        }
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        Set<String> keys=map.keySet();
        for(String str: keys){
            ans.add(map.get(str));
        }
        
        return ans;
        
        
        
    }
}
