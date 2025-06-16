class Solution {
    public int maximumDifference(int[] arr) {

        /*
        int n = arr.length;
        int ans = -1;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(arr[i] < arr[j]) {
                    ans = Math.max(ans, arr[j]-arr[i]);
                }
            }
        }
        return ans;
        */

        // Using Stack
        /*
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = -1;
        stack.addFirst(arr[0]);
        for(int i=1;i<arr.length;i++) {
            if(arr[i] <= stack.getFirst()) {
                stack.addFirst(arr[i]);
            } else{
                ans = Math.max(ans, arr[i]-stack.getFirst());
            }
        }
        return ans;
        */

        // Without stack
        int stackTop = arr[0];
        int ans = -1;
        for(int i=1;i<arr.length;i++) {
            if(arr[i] <= stackTop) {
                stackTop = arr[i];
            } else {
                ans = Math.max(ans, arr[i]-stackTop);
            }
        }
        return ans;
    }
}