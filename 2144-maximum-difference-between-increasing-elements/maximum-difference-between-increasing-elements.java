class Solution {
    public int maximumDifference(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(arr[i] < arr[j]) {
                    ans = Math.max(ans, arr[j]-arr[i]);
                }
            }
        }
        return ans;
    }
}