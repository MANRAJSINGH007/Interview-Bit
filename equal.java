class Pair{
    
    int x1;
    int x2;
    
    Pair(int x1, int x2){
        this.x1=x1;
        this.x2=x2;
    }
    
}
public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> list) {
        
        if(list==null || list.size()==0){
            return new ArrayList<>();
        }
        
        HashMap<Integer,ArrayList<Pair>> map=new HashMap<>();
        
        int n=list.size();
        
        int min_a=n;
        int min_b=n;
        int min_c=n;
        int min_d=n;
        
        for(int i=0;i<n;i++){
            
            for(int j=i+1;j<n;j++){
                
                int sum=list.get(i)+list.get(j);
                
                if(map.containsKey(sum)){
                    ArrayList<Pair> temp=map.get(sum);
                    if(temp.size()==1){
                        Pair first=temp.get(0);
                        Pair second=new Pair(i,j);
                        if(second.x1!=first.x2 && second.x1!=first.x1 && first.x2!=second.x2){
                            
                            temp.add(second);
                            
                            if(min_a>first.x1){
                                min_a=first.x1;
                                min_b=first.x2;
                                min_c=second.x1;
                                min_d=second.x2;
                            }
                            else if(min_a==first.x1){
                                if(min_b>first.x2){
                                    min_b=first.x2;
                                    min_c=second.x1;
                                    min_d=second.x2;
                                }
                                else if(min_b==first.x2){
                                    if(min_c>second.x1){
                                        min_c=second.x1;
                                        min_d=second.x2;
                                    }
                                    else if(min_c==second.x1){
                                        if(second.x2<min_d){
                                            min_d=second.x2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                else{
                    ArrayList<Pair> temp=new ArrayList<>();
                    temp.add(new Pair(i,j));
                    map.put(sum,temp);
                }
                
            }
            
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        if(min_a!=n && min_c!=n){
            ans.add(min_a);
            ans.add(min_b);
            ans.add(min_c);
            ans.add(min_d);
        }
        
        return ans;
        
    }
}
