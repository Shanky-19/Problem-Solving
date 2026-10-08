class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            int currXor = arr[i];
            for(int k=i+1;k<n;k++) {
                currXor ^= arr[k];
                if(currXor == 0) {
                    ans += (k-i);
                }
            }
        }
        return ans;
    }
}