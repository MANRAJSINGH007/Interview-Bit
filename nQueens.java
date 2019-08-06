public class Solution {
    
    static ArrayList<ArrayList<String>> ans=new ArrayList<>();
    
    public static boolean isSafe(String[][] board, int i, int j){
        
        int n=board.length;
        
        for(int row=0;row<i;row++){
            if(board[row][j].equals("Q")){
                return false;
            }
            for(int col=0;col<n;col++){
                if((i-row==col-j || i-row==j-col) && board[row][col].equals("Q")){
                    return false;
                }
            }
        }
        
        return true;
        
    }
    
    public static void add(String[][] board){
        
        ArrayList<String> curr=new ArrayList<>();
        
        int n=board.length;
        
        for(int i=0;i<n;i++){
            String temp="";
            for(int j=0;j<n;j++){
                temp+=board[i][j];
            }
            
            curr.add(temp);
        }
        
        ans.add(curr);
        return ;
    }
    
    public static void nQueens(int row, int n, String[][] board){
        
        if(row==n){
            add(board);
            return ;
        }
        
        for(int j=0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j]="Q";
                nQueens(row+1,n,board);
                board[row][j]=".";
            }
        }
        
        return ;
        
        
    }
    
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        
        if(n==0){
            return new ArrayList<>();
        }
        
        ans=new ArrayList<>();
        
        String board[][]=new String[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=".";
            }
        }
        
        nQueens(0,n,board);
        return ans;
        
    }
}
