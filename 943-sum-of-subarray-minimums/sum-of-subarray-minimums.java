class Solution {

    private int[] nearestLesserElementToLeft (int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++) {
            while(st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private int[] nearestLesserElementToRight (int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(st.size() > 0 && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if(st.size() == 0) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int mod = (int) (1e9 + 7);
        int n = arr.length;
        long ans = 0;
        
        int[] nearestLesserElementToLeft =
        nearestLesserElementToLeft(arr);

        int[] nearestLesserElementToRight =
        nearestLesserElementToRight(arr);

        for(int i=0;i<n;i++) {
            int rightEnd = nearestLesserElementToRight[i];
            int leftEnd = nearestLesserElementToLeft[i];


            long subArrays = ((rightEnd-i) * (i-leftEnd))%mod;
            long product = (subArrays * arr[i])%mod;


            ans = (ans + product)%mod;
        }

        return (int) ans;
    }
}