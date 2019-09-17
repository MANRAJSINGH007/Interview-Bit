public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int k) {
        
        int n = A.size();
        
        int start = 0;
        int end = 0;
        
        int maxStart = 0;
        int maxEnd = 0;
        
        int count = 0;
        
        while(end < n && count < k){
            
            if(A.get(end) == 0){
                count++;
            }
            
            end++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(end == n){
            for(int j = 0; j < n; j++){
                ans.add(j);
            }
            return ans;
        }
        
        while(end < n && A.get(end) == 1){
            end++;
        }
        
        if(end == n){
            for(int j = 0; j < n; j++){
                ans.add(j);
            }
            return ans;
        }
        
        int max = end - start;
        maxStart = start;
        maxEnd = end - 1;
        
        // now A[end] is definitely 0.
        
        while(end < n){
            
            while(start < end && A.get(start) == 1){
                start++;
            }
            
            start++;
            end++;
            
            while(end < n && A.get(end) == 1){
                end++;
            }
            
            if(max < end - start){
                maxStart = start;
                maxEnd = end - 1;
                max = end - start;
            }
            
        }
        
        for(int j = maxStart; j <= maxEnd; j++){
            ans.add(j);
        }
        
        return ans;
        
    }
}
