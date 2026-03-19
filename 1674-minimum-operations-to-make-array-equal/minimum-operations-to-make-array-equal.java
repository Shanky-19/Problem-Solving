class Solution {
    public int minOperations(int n) {
        // sare elements ko n ke equal karna hai
        // int ans = 0;
        // for(int i=0;(2*i+1) < n;i++){
        //     ans += (n-(2*i+1));
        // }
        // return ans;

        int k = n/2;
		return (k) * (n-k);
    }
}