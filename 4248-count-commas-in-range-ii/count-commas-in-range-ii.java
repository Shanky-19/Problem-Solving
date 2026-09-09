class Solution {
    public long countCommas(long n) {
        long ans = 0L;
        String s = n + "";
        for(int i=4;i<=s.length();i++) {
            int commas = (i - 1)/3;
            
            if(s.length() == i) {
                ans += commas * (n - Math.pow(10, i-1) + 1);
            } else {
                ans += commas * (Math.pow(10, i) - Math.pow(10, i-1));
            }
        }
        return ans;
    }
}