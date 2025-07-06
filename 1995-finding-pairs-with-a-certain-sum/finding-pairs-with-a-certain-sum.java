class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> nums2ValueVsNumberOfIdx;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.nums2ValueVsNumberOfIdx = new HashMap<>();
        for(int idx=0;idx<nums2.length;idx++) {
            nums2ValueVsNumberOfIdx.put(nums2[idx], nums2ValueVsNumberOfIdx.getOrDefault(nums2[idx], 0)+1);
        }
    }
    
    public void add(int index, int val) {
        int currentValue = nums2[index];
        nums2[index] += val;
        if(nums2ValueVsNumberOfIdx.containsKey(currentValue)) {
            nums2ValueVsNumberOfIdx.put(currentValue, nums2ValueVsNumberOfIdx.get(currentValue) - 1);
            if(nums2ValueVsNumberOfIdx.get(currentValue) <= 0) {
                nums2ValueVsNumberOfIdx.remove(currentValue);
            }
        } 
        nums2ValueVsNumberOfIdx.put(nums2[index], nums2ValueVsNumberOfIdx.getOrDefault(nums2[index], 0)+1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for(int i=0;i<nums1.length;i++) {
            int remainingValue = tot - nums1[i];
            if(nums2ValueVsNumberOfIdx.containsKey(remainingValue)) {
                ans += nums2ValueVsNumberOfIdx.get(remainingValue);
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