class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char[] firstHalf = s.substring(0, n/2).toCharArray();
        Arrays.sort(firstHalf);
        char[] ans = new char[n];
        for(int i=0;i<n/2;i++) {
            ans[i] = firstHalf[i];
            ans[n-1-i] = firstHalf[i];
        }

        if(n%2 != 0) {
            ans[n/2] = s.charAt(n/2);
        }

        return new String(ans);
    }
}