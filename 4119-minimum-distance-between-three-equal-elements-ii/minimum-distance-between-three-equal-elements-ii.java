class Solution {
    class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair (int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }
    public int minimumDistance(int[] nums) {
        // Brute Force
        /*
            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            for(int i=0;i<n-2;i++) {
                for(int j=i+1;j<n-1;j++) {
                    if(nums[i] == nums[j]) {
                        for(int k=j+1;k<n;k++) {
                            if(nums[j] == nums[k]) {
                                int potentialAns = (Math.abs(i-j) + Math.abs(j-k) + Math.abs(i-k));
                                ans = Math.min(ans, potentialAns); 
                            }
                        }
                    }
                }
            }
            if(ans == Integer.MAX_VALUE) {
                return -1;
            }
            return ans;
        */

        int n = nums.length;
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++) {
            arr[i] = new Pair(nums[i], i);
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++) {
            if(arr[i].val == arr[i+2].val) {
                
                int potentialAns = Math.abs(arr[i].idx - arr[i+1].idx) 
                                    + Math.abs(arr[i+1].idx - arr[i+2].idx) 
                                    + Math.abs(arr[i+2].idx - arr[i].idx);
                ans = Math.min(ans, potentialAns);
            }
        }
        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}