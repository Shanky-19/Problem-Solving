class Solution {
    public String breakPalindrome(String pal) {
        int n = pal.length();
        if(n == 1) {
            return "";
        }
        
        for(int i = 0; i<n/2; i++) {
            if(pal.charAt(i) != 'a') {
                String ans = pal.substring(0, i);
                ans += "a";
                ans += pal.substring(i+1);
                return ans;
            }
        }
        
        String ans = pal.substring(0,n-1);
        ans += "b";
        return ans;
    }
}