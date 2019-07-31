public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> arr) {
        
        int n=arr.size();
        
        if(n==0){
            return new ArrayList<>();
        }
        
        int max_start=0;
        int max_end=0;
        long max_sum=(long)arr.get(0);
        int i=0;
        
        while(i<n && arr.get(i)<0){
            i++;
        }
        
        if(i==n){
            return new ArrayList<>();
        }
        
        max_sum=(long)arr.get(i);
        max_start=i;
        max_end=i;
        int max_length=1;
        int curr_length=0;
        long curr_sum=0;
        int curr_start=i;
        int curr_end=0;
        
        while(i<n){
            while(i<n && arr.get(i)>=0){
                curr_length++;
                curr_end=i;
                curr_sum+=(long)arr.get(i);
                if(curr_sum>max_sum){
                    max_sum=curr_sum;
                    max_length=curr_length;
                    max_start=curr_start;
                    max_end=curr_end;
                }
                else if(curr_sum==max_sum){
                    if(curr_length>max_length){
                        max_sum=curr_sum;
                        max_length=curr_length;
                        max_start=curr_start;
                        max_end=curr_end;
                    }
                    else if(curr_length==max_length){
                        if(curr_start<max_start){
                            max_sum=curr_sum;
                            max_length=curr_length;
                            max_start=curr_start;
                            max_end=curr_end;
                        }
                    }
                }
                
                i++;
            }
            
            if(i==n){
                break;
            }
            
            while(i<n && arr.get(i)<0){
                i++;
            }
            
            if(i==n){
                break;
            }
            
            curr_sum=0;
            curr_length=0;
            curr_start=i;
            curr_end=i-1;
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        for(int k=max_start;k<=max_end;k++){
            ans.add(arr.get(k));
        }
        
        return ans;
        
    }
}
