class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int numOfFillAppend = k-n%k;
        StringBuilder sb = new StringBuilder();
        while(numOfFillAppend < k && numOfFillAppend-- > 0) {
            sb.append(fill);
        }
        s += sb.toString();
        n = s.length();
        // System.out.println(s);
        String[] ans = new String[n/k];
        for(int i=0;i<n;i+=k) {
            // System.out.println(i + " " + (i+k));
            ans[i/k] = s.substring(i, i+k);
        }
        return ans;


    }
}