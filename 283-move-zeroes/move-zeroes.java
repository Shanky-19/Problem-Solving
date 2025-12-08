class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int[] help = new int[n];
        int i=0;
        for(int val : arr){
            if(val != 0){
                help[i] = val;
                i++;
            }
        }
        while(i < n){
            help[i] = 0;
            i++;
        }
        i = 0;
        for(int val : help){
            arr[i] = val;
            i++;
        }
    }
}