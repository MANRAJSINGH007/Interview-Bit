public class Solution {
    public int sqrt(int A) {
        int start = 1, end = A;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(A / mid == mid) return mid;
            if(A / mid > mid) start = mid + 1;
            else end = mid - 1;
        }
        return end;
    }
}
