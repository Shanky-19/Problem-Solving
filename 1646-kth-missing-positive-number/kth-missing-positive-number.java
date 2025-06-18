class Solution {
    public int findKthPositive(int[] arr, int k) {
        // brute force
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
        
        
    }
}