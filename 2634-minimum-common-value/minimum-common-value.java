class Solution {
    
    public int binarySearch(int[] arr,int val,int si,int ei){
        while(si <= ei){
            int mid = (si + ei)/2;
            if(arr[mid] == val){
                return val;
            }else if(arr[mid] > val){
                ei = mid - 1;
            }else{
                si = mid+1;
            }
        }
        return -1;
    }

    public int getCommon(int[] nums1, int[] nums2) {
        for(int val : nums2){
            int ans = binarySearch(nums1,val,0,nums1.length-1);
            if(ans != -1){
                return ans;
            }
        }
        return -1;
    }

}