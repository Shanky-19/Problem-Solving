class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> nums1ValueVsNumberOfIdx;
    Map<Integer, Integer> nums2ValueVsNumberOfIdx;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.nums1ValueVsNumberOfIdx = new HashMap<>();
        this.nums2ValueVsNumberOfIdx = new HashMap<>();
        for(int idx=0;idx<nums1.length;idx++) {
            nums1ValueVsNumberOfIdx.put(nums1[idx], nums1ValueVsNumberOfIdx.getOrDefault(nums1[idx], 0)+1);
        }
        for(int idx=0;idx<nums2.length;idx++) {
            nums2ValueVsNumberOfIdx.put(nums2[idx], nums2ValueVsNumberOfIdx.getOrDefault(nums2[idx], 0)+1);
        }
        
    }
    
    public void add(int index, int val) {
        int currentValue = nums2[index];
        nums2[index] += val;
        nums2ValueVsNumberOfIdx.put(currentValue, nums2ValueVsNumberOfIdx.get(currentValue) - 1);
        if(nums2ValueVsNumberOfIdx.get(currentValue) <= 0) {
            nums2ValueVsNumberOfIdx.remove(currentValue);
        }
        nums2ValueVsNumberOfIdx.put(nums2[index], nums2ValueVsNumberOfIdx.getOrDefault(nums2[index], 0)+1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for(int key : nums1ValueVsNumberOfIdx.keySet()) {
            int remainingValue = tot - key;
            if(nums2ValueVsNumberOfIdx.containsKey(remainingValue)) {
                ans += nums2ValueVsNumberOfIdx.get(remainingValue) * nums1ValueVsNumberOfIdx.get(key);
            }
        } 
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */