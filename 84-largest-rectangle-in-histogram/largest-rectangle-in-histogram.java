class Solution {
    public int largestRectangleArea(int[] heights) {
        // code here
        int n = heights.length;
        int[] nextSmallerElementIdxToLeft = 
        nextSmallerElementIdxToLeft(heights);
        
        int[] nextSmallerElementIdxToRight = 
        nextSmallerElementIdxToRight(heights);
        
        int ans = 0;
        for(int i=0;i<n;i++) {
            int leftArea = (i-nextSmallerElementIdxToLeft[i]) * heights[i];
            int rightArea = (nextSmallerElementIdxToRight[i]-i) * heights[i];
            int totalArea = leftArea+rightArea-(heights[i]*1);
            ans = Math.max(ans, totalArea);
        }
        return ans;
    }

    private int[] nextSmallerElementIdxToLeft(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            while(stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            if(stack.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }  
            stack.push(i);
        }
        return ans;
    }
    
    private int[] nextSmallerElementIdxToRight(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--) {
            while(stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            if(stack.size() == 0) {
                ans[i] = n;
            } else {
                ans[i] = stack.peek();
            }  
            stack.push(i);
        }
        return ans;
    }

}