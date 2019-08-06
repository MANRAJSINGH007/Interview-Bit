/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> list) {
        
        if(list==null || list.size()==0){
            return new ArrayList<>();
        }
        
        int n=list.size();
        
        Collections.sort(list, new Comparator<Interval>() {    
                @Override
                public int compare(Interval i1, Interval i2) {
                    
                    if(i1.start<i2.start){
                        return -1;
                    }
                    
                    else if(i1.start==i2.start){
                        return 0;
                    }
                    
                    return 1;
                }               
        });
        
        int prev=0;
        int curr_index=1;
        
        for(int i=1;i<n;i++){
            
            Interval i1=list.get(prev);
            Interval i2=list.get(curr_index);
            if(i1.end<i2.start){
                prev=curr_index;
                curr_index++;
            }
            else{
                list.set(prev,new Interval(i1.start,Math.max(i1.end,i2.end)));
                list.remove(curr_index);
            }
        }
        
        return list;

    }
}
