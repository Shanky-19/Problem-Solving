class Solution {

    private int calculateSum(String str) {
        int sum = 0;
        for(char ch : str.toCharArray()) {
            sum += (ch - '0');
        }
        return sum;
    }
    public String digitSum(String s, int k) {

        while(s.length() > k) {
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            int groups = (int)Math.ceil((1.0 * n)/k);
            int i = 0;
            while(groups-- > 0) {
                String substring = s.substring(i, Math.min(i+k, n));
                // System.out.println(substring);
                int sum = calculateSum(substring);
                sb.append("" + sum);
                i+=k;
            }
            s = sb.toString();
        }
        return s;
    }
}