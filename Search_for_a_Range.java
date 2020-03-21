public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int n = A.size();
        int start = 0, end = n - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(-1);
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(A.get(mid) == B) ans.set(0, mid);
            if(A.get(mid) >= B) end = mid - 1;
            else start = mid + 1;
        }
        if(ans.get(0) == -1) return ans;
        start = 0;
        end = n - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(A.get(mid) == B) ans.set(1, mid);
            if(A.get(mid) <= B) start = mid + 1;
            else end = mid - 1;
        }
        return ans;
    }
}
