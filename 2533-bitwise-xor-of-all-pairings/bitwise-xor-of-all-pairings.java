class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int k = nums2.length;
        int x1=0;
        int x2=0;
        if(k%2!=0){
            for(int i=0;i<m;i++){
                x1^=nums1[i];
            }
        }
        if(m%2!=0){
            for(int i=0;i<k;i++){
                x2^=nums2[i];
            }
        }return x1^x2;
    }
}