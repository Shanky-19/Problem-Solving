class Solution {
    public int removeDuplicates(int[] nums) {
        int i=2;
        for(int j=2;j<nums.length;j++){
            
            if(i==0 || i==1 || nums[i-2]!=nums[j]){
                nums[i]=nums[j];
                i+=1;
            }
        }
        
        return i;
    }
}