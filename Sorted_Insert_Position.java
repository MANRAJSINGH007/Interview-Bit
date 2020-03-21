public class Solution {
    public int searchInsert(ArrayList<Integer> a, int b) {
        int n = a.size();
        int start = 0, end = n - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(a.get(mid) == b) return mid;
            if(a.get(mid) > b) end = mid - 1;
            else start = mid + 1;
        }
        return end + 1;
    }
}
