/*
    Refers -> https://leetcode.com/problems/subarray-sum-equals-k/ 
    -> Subarray Sum Equals K
    
    // start from row 1 
        1. find count of subarray sum equal to target using above question
        2. go to next row2 -> add the elements from prev row, 
            and with this modified row find the subarray sum equal to target. 
            (this represents the subarray have row1 and row2)
        3. do this for row3 and so on (row1 and row2 and row3) and .....

    // start from row2 -> this row will remain constant
        1. find count of subarray sum equal to target using above question
        2. go to next row3 -> add the elements from
            prev row, and with this modified row 
            find the subarray sum equal to target. 
            (this represents the subarray have row2 and row3)
        3. do this for row3 and so on (row1 and row2 and row3) and .....

    // start from row3 and so on..
*/
class Solution {

    public int subarraySumEqualToK(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(sum,1);
        
        for(int val : nums){
            sum += val;
            
            if(hm.containsKey(sum-k)){
                ans += hm.get(sum-k);
            }
            
            if(hm.containsKey(sum)){
                hm.put(sum,hm.get(sum)+1);
            }else{
                hm.put(sum,1);
            }
        }
        return ans;
        
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[] summedRow = new int[n];
        for(int i=0;i<m;i++){// i is starting row
            Arrays.fill(summedRow,0);
            for(int j=i;j<m;j++){ // j is ending row
                for(int k=0;k<n;k++){
                    summedRow[k] += matrix[j][k];
                }

                ans += subarraySumEqualToK(summedRow,target);
            }
        }
        return ans;
    }
}