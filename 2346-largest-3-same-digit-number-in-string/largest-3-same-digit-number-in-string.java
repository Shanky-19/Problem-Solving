class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int max = -1;
        for(int i=0;i<n-2;i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i+1);
            char c3 = num.charAt(i+2);
            if(c1 == c2 && c2 == c3) {
                StringBuilder s = new StringBuilder();
                s.append(c1);
                s.append(c2);
                s.append(c3);
                max = Math.max(max, Integer.parseInt(s.toString()));
            }
        }
        if(max == -1) {
            return "";
        }
        return (max == 0) ? "000" : ("" + max);
    }
}