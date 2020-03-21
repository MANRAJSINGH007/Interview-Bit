public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size(), m = A.get(0).size();
        int start = 0, end = n - 1, mid = -1;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(A.get(mid).get(0) <= B && A.get(mid).get(m - 1) >= B) break;
            if(A.get(mid).get(0) > B) end = mid - 1;
            else start = mid + 1;
        }
        if(start > end) return 0;
        start = 0;
        end = m - 1;
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if(A.get(mid).get(middle) == B) return 1;
            if(A.get(mid).get(middle) < B) start = middle + 1;
            else end = middle - 1;
        }
        return 0;
    }
}
