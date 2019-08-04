public class Solution {
    
	public int removeDuplicates(ArrayList<Integer> list) {
	    
	    if(list==null || list.size()==0){
	        return 0;
	    }
	    
	    int n=list.size();
	    int prev=list.get(0);
	    int index=1;
	    
	    for(int i=1;i<list.size();i++){
	        int curr=list.get(i);
	        if(prev!=curr){
	            list.set(index,curr);
	            prev=curr;
	            index++;
	        }
	    }
	    
	    return index;
	    
	}
}
