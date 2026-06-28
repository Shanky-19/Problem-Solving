class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        // moore's voting algo to find dominant
        int dominant = nums.get(0);
        int count = 1;
        for(int i=1;i<n;i++) {
            int val = nums.get(i);
            if(val == dominant) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                dominant = val;
                count = 1;
            }
        }
        // System.out.println(dominant);

        int freqOfDominant = 0;
        for(int val : nums) {
            if(val == dominant) {
                freqOfDominant++;
            }
        }

        int freqOfDominantOnLeftSubarray = 0;
        for(int i=0;i<n;i++) {
            int sizeOfLeft = i+1;
            int val = nums.get(i);
            if(val == dominant) {
                freqOfDominantOnLeftSubarray++;
            }
            if(freqOfDominantOnLeftSubarray > sizeOfLeft/2
                && (freqOfDominant - freqOfDominantOnLeftSubarray > (n-i-1)/2)) {
                return i;
            }
        }
        return -1;        
    }
}