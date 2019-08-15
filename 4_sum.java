public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> list, int x) {
        
        if(list==null || list.size()<=3){
            return new ArrayList<>();
        }
        
        Collections.sort(list);
        
        int n=list.size();
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<n-3;i++){
            
            int x1=list.get(i);
            
            for(int j=i+1;j<n-2;j++){
                
                int x2=list.get(j);
                
                int start=j+1;
                int end=n-1;
                
                while(start<end){
                    
                    int sum=x1+x2+list.get(start)+list.get(end);
                    
                    if(sum==x){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(x1);
                        temp.add(x2);
                        temp.add(list.get(start));
                        temp.add(list.get(end));
                        ans.add(temp);
                        
                        while(start<end && list.get(start)==list.get(start+1)){
                            start++;
                        }
                        
                        while(start<end && list.get(end)==list.get(end-1)){
                            end--;
                        }
                        
                        start++;
                        
                    }
                    
                    else if(sum<x){
                        start++;
                    }
                    
                    else{
                        end--;
                    }
                    
                }
                
                while(j<n-2 && list.get(j)==list.get(j+1)){
                    j++;
                }
                
            }
            
            while(i<n-3 && list.get(i)==list.get(i+1)){
                i++;
            }
        }
        
        return ans;
        
    }
}
