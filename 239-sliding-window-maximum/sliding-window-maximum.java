class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int j = 0;
        for(int i=0;i<n;i++) {
            // step 1 : window size should be lesser or equal to k
            while(dq.size() > 0 && dq.getFirst() < i-k+1) {
                dq.removeFirst();
            }

            // step 2 : remove elements which are lesser than nums[i]
            while (dq.size() > 0 && nums[i] >= nums[dq.getLast()]) {
                dq.removeLast();
            }

            // step 3 : push i at last of deque
            dq.addLast(i);

            // step 4 : Check front of dq for valid window
            if(i >= k-1) {
                ans[j] = nums[dq.getFirst()];
                j++;
            }
        }
        return ans;
    }
}