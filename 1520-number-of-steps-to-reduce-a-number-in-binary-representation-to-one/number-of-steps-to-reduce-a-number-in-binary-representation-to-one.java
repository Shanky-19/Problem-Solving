class Solution {

    private boolean isOne (String s) {
        int n = s.length();
        if(s.charAt(n-1) == '1') {
            s = s.substring(0, n-1);
            for(char ch : s.toCharArray()) {
                if(ch == '1') {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public int numSteps(String s) {
        int count = 0;
        while (!isOne(s)) {
            if(s.charAt(s.length()-1) == '0') {
                s = s.substring(0, s.length()-1);
            } else {
                s = plusOne(s);
            }
            count++;
        }
        return count;
    }



    private String plusOne(String s) {
        int j = s.length()-1;
        while(j>= 0 && s.charAt(j) == '1') {
            j--;
        }
        StringBuilder sb = new StringBuilder();
        if(j == -1) {
            sb.append('1');
            int i = 0;
            while(i < s.length()) {
                sb.append('0');
                i++;
            }
        } else {
            sb.append(s.substring(0, j));
            sb.append('1');
            int x = j+1;
            while(x < s.length()) {
                sb.append('0');
                x++;
            }
        }
        return sb.toString();
    }
}