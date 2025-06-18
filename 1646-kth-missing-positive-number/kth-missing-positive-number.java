class Solution {
    public int findKthPositive(int[] arr, int k) {
        // brute force
        /*
        int num = 1;
        int i = 0;
        while(i< arr.length && k > 0) {
            if(num == arr[i]) {
                // non missing number
                i++;
            }else {
                // missing number
                k--;
            }
            num++;
        }
        while(k-- > 0) {
            num++;
        }
        return num-1;
        */


        // Binary Search

        int n = arr.length;
        int l = 0;
        int r = n-1;
        int mid = -1;
        while(l <= r) {
            mid = l+ (r-l)/2;
            int number_of_missing_till_mid = arr[mid] - (mid+1);
            if(number_of_missing_till_mid < k) {
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return l+k;
        
        
    }
}