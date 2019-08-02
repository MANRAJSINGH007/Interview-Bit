public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> distance) {
        
        int n=gas.size();
        int s1=0;
        int s2=0;
        
        for(int i=0;i<n;i++){
            s1+=gas.get(i);
            s2+=distance.get(i);
        }
        
        if(s1<s2){
            return -1;
        }
        
        if(n==0){
            return 0;
        }
        
        int start=0;
        int j=0;
        int balance=gas.get(0);
        
        while(start<n){
            
            int count=0;
            while(distance.get(j)<=balance){
                balance-=distance.get(j);
                j++;
                if(j==n){
                    j%=n;
                }
                balance+=gas.get(j);
                count++;
                if(count==n){
                    return start;
                }
            }
            
            j++;
            start=j;
            balance=gas.get(start);
            
        }
        
        return -1;
        
    }
}
