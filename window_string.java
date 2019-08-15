public class Solution {
    
    public static boolean check(int[] arr, int[] brr){
        
        for(int i=0;i<256;i++){
            if(brr[i]<arr[i]){
                return false;
            }
        }
        
        return true;
        
    }
    
    public String minWindow(String s1, String s2) {
        
        if(s1==null || s2==null || s2.equals("") || s1.equals("") || s1.length()<s2.length()){
            return "";
        }
        
        int n1=s1.length();
        int n2=s2.length();
        
        int arr[]=new int[256];
        
        for(int i=0;i<n2;i++){
            char curr=s2.charAt(i);
            arr[(int)curr]++;
        }
        
        int brr[]=new int[256];
        
        int min=Integer.MAX_VALUE;
        int left=-1;
        int right=-1;
        
        for(int i=0;i<n2;i++){
            brr[(int)s1.charAt(i)]++;
        }
        
        int start=0;
        int end=n2-1;
        
        while(end<n1){
            
            while(end<n1 && !check(arr,brr)){
                
                end++;
                if(end==n1){
                    break;
                }
                
                brr[(int)s1.charAt(end)]++;
            }
            
            if(end<n1){
                if(end-start+1<min){
                    min=end-start+1;
                    left=start;
                    right=end;
                }
                else if(end-start+1==min){
                    if(start<left){
                        left=start;
                        right=end;
                    }
                }
            }
            
            while(start<=end-n2+1 && check(arr,brr)){
                
                if(end-start+1<min){
                    min=end-start+1;
                    left=start;
                    right=end;
                }
                else if(end-start+1==min){
                    if(start<left){
                        left=start;
                        right=end;
                    }
                }
                
                brr[(int)s1.charAt(start)]--;
                start++;
            }
            
        }
        
        if(left==-1){
            return "";
        }
        
        return s1.substring(left,right+1);
        
        
    }
}
