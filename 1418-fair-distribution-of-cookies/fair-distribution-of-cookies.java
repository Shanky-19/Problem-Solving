class Solution {
    int result = Integer.MAX_VALUE;
    public void helper(int idx, int[] cookies,int[] children, int k) {
        if(idx == cookies.length) {
            
            int ans = children[0];
            for(int i=0;i<children.length;i++){
                ans = Math.max(ans,children[i]);
            }
            result = Math.min(result, ans);
            return;
        }
        
        int candy = cookies[idx];
        for(int i = 0; i<k; i++) {
            children[i] += candy;
            
            helper(idx+1, cookies, children, k);
            
            // backtrack
            children[i] -= candy;
        }
        
    }

    public int distributeCookies(int[] cookies, int k) {
        int[] childrens = new int[k];
        helper(0,cookies,childrens,k);
        return result;
    }
}