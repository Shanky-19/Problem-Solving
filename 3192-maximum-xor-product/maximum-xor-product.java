public class Solution {
    int M = 1000000007;

    public int maximumXorProduct(long a, long b, int n) {
        long xXora = 0;
        long xXorb = 0;

        for (long i = 49; i >= n; i--) {
            boolean aset = ((a >> i) & 1L) > 0; //Finding the ith bit of a
            boolean bset = ((b >> i) & 1L) > 0; //Finding the ith bit of b

            if (aset)
                xXora ^= (1L << i);
            if (bset)
                xXorb ^= (1L << i);
        }

        for (long i = n - 1; i >= 0; i--) {
            boolean aset = (a & (1L << i)) > 0;
            boolean bset = (b & (1L << i)) > 0;

            // If both ith bit of a and b are the same
            if (aset == bset) {
                xXora ^= (1L << i);
                xXorb ^= (1L << i);
                continue;
            }

            if (xXora > xXorb) {
                xXorb ^= (1L << i);
            } else {
                xXora ^= (1L << i);
            }
        }

        xXora %= M;
        xXorb %= M;
        return (int) ((xXora * xXorb) % M);
    }
}