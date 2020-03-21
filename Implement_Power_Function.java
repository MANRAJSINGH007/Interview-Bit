public class Solution {
    public static int power(int x, int n, int d) {
        if(n == 0) return 1;
        int small = power(x, n/2, d);
        long temp = ((long)small * small) % d;
        if(n % 2 == 1) temp = (temp * (x % d)) % d;
        return (int)temp;
    }
    public int pow(int x, int n, int d) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        int ans = power(x, n , d);
        return ans < 0 ? d + ans : ans;
    }
}
