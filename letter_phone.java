public class Solution {
    
    public static ArrayList<String> func(String str, int i, int n, HashMap<Character,ArrayList<Character>> map){
        
        if(i==n){
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        ArrayList<String> temp=func(str,i+1,n,map);
        
        ArrayList<String> ans=new ArrayList<>();
        
        char curr=str.charAt(i);
        ArrayList<Character> arr=map.get(curr);
        
        for(int p=0;p<arr.size();p++){
            char c=arr.get(p);
            for(int j=0;j<temp.size();j++){
                String h=temp.get(j);
                String t=""+c+h;
                ans.add(t);
            }
        }
        
        return ans;
    }
    
    public ArrayList<String> letterCombinations(String str) {
        
        int n=str.length();
        
        if(n==0){
            return new ArrayList<>();
        }
        
        HashMap<Character,ArrayList<Character>> map=new HashMap<>();
        
        ArrayList<Character> list=new ArrayList<>();
        list.add('0');
        
        map.put('0',list);
        
        list=new ArrayList<>();
        list.add('1');
        map.put('1',list);
        
        list=new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        map.put('2',list);
        
        list=new ArrayList<>();
        list.add('d');
        list.add('e');
        list.add('f');
        map.put('3',list);
        
        list=new ArrayList<>();
        list.add('g');
        list.add('h');
        list.add('i');
        map.put('4',list);
        
        list=new ArrayList<>();
        list.add('j');
        list.add('k');
        list.add('l');
        map.put('5',list);
        
        list=new ArrayList<>();
        list.add('m');
        list.add('n');
        list.add('o');
        map.put('6',list);
        
        list=new ArrayList<>();
        list.add('p');
        list.add('q');
        list.add('r');
        list.add('s');
        map.put('7',list);
        
        list=new ArrayList<>();
        list.add('t');
        list.add('u');
        list.add('v');
        map.put('8',list);
        
        list=new ArrayList<>();
        list.add('w');
        list.add('x');
        list.add('y');
        list.add('z');
        map.put('9',list);
        
        
        ArrayList<String> ans=func(str,0,n,map);
        
        Collections.sort(ans);
        
        return ans;
        
    }
}
