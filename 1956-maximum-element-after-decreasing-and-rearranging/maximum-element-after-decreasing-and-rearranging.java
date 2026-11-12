class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        if(arr[0] != 1) {
            arr[0] = 1;
        }
        max = Math.max(arr[0], max);

        for(int i=1;i<arr.length;i++) {
            int diff = Math.abs(arr[i] - arr[i-1]);
            if(!(diff <= 1)) {
                arr[i] = arr[i-1] + 1;
            }
            max = Math.max(arr[i], max);
        }

        return max;
    }
}