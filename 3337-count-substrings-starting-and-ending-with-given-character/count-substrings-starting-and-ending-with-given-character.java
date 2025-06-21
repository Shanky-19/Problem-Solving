class Solution {
    // Method to calculate the factorial of a number
    static long factorial(int num) {
        long res = 1;
        for (int i = 2; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    // Method to calculate nCr using factorials
    static long nCr(int n, int r) {
        if (r < 0 || r > n) {
            return 0; // Invalid input for combinations
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public long countSubstrings(String s, char c) {
        long n = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c) {
                n++;
            }
        }
        if(n ==0) {
            return 0;
        }
        return ((n-1) * (n))/2 + n;
    }
}