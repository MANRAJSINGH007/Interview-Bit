public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> arr) {
        
        int n=arr.size();
        int i=0;
        while(i<n && arr.get(i)==0){
            i++;
        }
        
        if(i==n){
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(1);
            return ans;
        }
        
        else{
            if(i==0){
                int carry=1;
                int j=n-1;
                for(j=n-1;j>=0;j--){
                    int sum=carry+arr.get(j);
                    arr.set(j,sum%10);
                    carry=sum/10;
                    if(carry==0){
                        break;
                    }
                }
                
                if(j==-1){
                    if(carry==0){
                        return arr;
                    }
                    else{
                        ArrayList<Integer> ans=new ArrayList<>();
                        ans.add(1);
                        for(int k=1;k<=n;k++){
                            ans.add(arr.get(k-1));
                        }
                        
                        return ans;
                    }
                }
                
                return arr;
            }
            
            else{
                int index=i-1;
                int carry=1;
                for(int j=n-1;j>index;j--){
                    int sum=carry+arr.get(j);
                    arr.set(j,sum%10);
                    carry=sum/10;
                    if(carry==0){
                        break;
                    }
                }
                if(carry==1){
                    arr.set(index,1);
                    ArrayList<Integer> ans=new ArrayList<>();
                    for(int k=0;k<n-index;k++){
                        ans.add(arr.get(index+k));
                    }
                    
                    return ans;
                }
                
                else{
                    ArrayList<Integer> ans=new ArrayList<>();
                    for(int k=0;k<n-index-1;k++){
                        ans.add(arr.get(index+k+1));
                    }
                    
                    return ans;
                }
            }
        }
    }
}
