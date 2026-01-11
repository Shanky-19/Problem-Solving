class Solution {

    public int[] nearestSmallestOnLeft(int[] arr){
        // [4   1  3  3  2]
        // [-1 -1  1  1  1]
        int n = arr.length;
        int[] ans = new int[n];
        ans[0] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int i = 1;
        while(i < n){
            int val = arr[i];
            while(st.size() > 0 && arr[st.peek()] >= val){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
            i++;
        }

        return ans;
    }

    public int[] nearestSmallestOnright(int[] arr){
        // [4  0  8  3  1]
        // [1  5  3  4  5]
        int n = arr.length;
        int[] ans = new int[n];
        ans[n-1] = n;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        int i = n-2;
        while(i >= 0){
            int val = arr[i];
            while(st.size() > 0 && arr[st.peek()] >= val){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = n;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
            i--;
        }

        return ans;
    }

    public int largestRectangleHistogram(int[] arr){
        int[] nearestSmallestOnLeft = nearestSmallestOnLeft(arr);
        int[] nearestSmallestOnright = nearestSmallestOnright(arr);



        int area = 0;
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = nearestSmallestOnright[i]-nearestSmallestOnLeft[i]-1;
            area = Math.max(area,height*width);
        }
        return area;

    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] mat = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    mat[i][j] = 1;
                }else{
                    mat[i][j] = 0;
                }
            }
        }

        int[] arr = mat[0];
        int ans = largestRectangleHistogram(arr);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 1){
                    arr[j] += 1;
                }else{
                    arr[j] = 0;
                }
            }
            int temp = largestRectangleHistogram(arr);
            ans = Math.max(ans,temp);
        }

        return ans;
    }
}