class Solution {
    public int[] singleNumber(int[] nums) {
        int ansXor = 0;
        for(int val : nums){
            ansXor = ansXor ^ val;
        }
        // xor of two number to numbers
        int rsbm = ansXor & -ansXor; // right most set bit
    
        int setA = 0;
        int setB = 0;
        for(int val : nums){
            if((val & rsbm) == 0){
                setA = setA ^ val;
            }else{
                setB = setB ^ val;
            }
        }
        int[] ans = new int[2];
        ans[0] = setA;
        ans[1] = setB;
        return ans;
    }
}