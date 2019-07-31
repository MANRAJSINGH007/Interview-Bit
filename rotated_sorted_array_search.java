public class Solution {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> arr, int target) {
        
        int n=arr.size();
        int start=0;
        int end=n-1;
        int mid=(start+end)/2;
        
        while(start<=end){
            
            mid=(start+end)/2;
            
            if(arr.get(mid)==target){
                return mid;
            }
            
            if(arr.get(start)==target){
                return start;
            }
            
            if(arr.get(end)==target){
                return end;
            }
            
            if(arr.get(mid)>target && target>arr.get(start)){
                end=mid-1;
            }
            
            else if(arr.get(start)>arr.get(mid) && (arr.get(start)<target || arr.get(mid)>target)){
                end=mid-1;
            }
            
            else{
                start=mid+1;
            }
            
        }
        
        return -1;
        
    }
}
