// class Solution {
//     public int[] smallestSubarrays(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[n];
//         int[] maxOrArrayStartingAtIdx = new int[n];
//         maxOrArrayStartingAtIdx[n-1] = nums[n-1];
//         for(int i=n-2;i>=0;i--) {
//             maxOrArrayStartingAtIdx[i] = nums[i] | maxOrArrayStartingAtIdx[i+1];
//         }
//         for(int i=0;i<n;i++) {
//             int val = nums[i];
//             int maxOr = maxOrArrayStartingAtIdx[i];
//             if(val == maxOr) {
//                 ans[i] = 1;
//             } else {
//                 int j = i+1;
//                 while(val != maxOr) {
//                     val |= nums[j];
//                     j++;
//                 }
//                 ans[i] = j-i;
//             }
//         }
//         return ans;
//     }
// }

class Solution 
{
    public int[] smallestSubarrays(int[] nums) 
    {
        int n = nums.length;
        int[] result = new int[n];
        // Step 2: Initialize latest array to track last seen position of each bit
        int[] latest = new int[32];
        Arrays.fill(latest, -1);

        // Step 3: Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) 
        {
            int farthest = i;  // Default: subarray ends at i
            // Step 4: Update latest seen positions for bits set in nums[i]
            for (int b = 0; b < 32; b++) 
            {
                if (((nums[i] >> b) & 1) != 0) 
                {
                    latest[b] = i;
                }
                // Step 5: For each bit, if seen, update farthest position needed
                if (latest[b] != -1) 
                {
                    farthest = Math.max(farthest, latest[b]);
                }
            }
            // Step 6: Store the length of smallest subarray starting at i
            result[i] = farthest - i + 1;
        }
        // Step 7: Return the result array
        return result;
    }
}