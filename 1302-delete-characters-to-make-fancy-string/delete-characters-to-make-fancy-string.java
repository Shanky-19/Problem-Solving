class Solution {
    public String makeFancyString(String s) {
        if(s.length() <= 2) {
            return s;
        }

        char prevPrev = s.charAt(0);
        char prev = s.charAt(1);
        StringBuilder sb = new StringBuilder();
        sb.append(prevPrev);
        sb.append(prev);
        for(int i=2;i<s.length();i++) {
            char curr = s.charAt(i);
            if((prevPrev == prev) &&  (prev == curr)) {
                continue;
            } else {
                sb.append(curr);
                prevPrev = prev;
                prev = curr;
            }
            
        }
        return sb.toString();
    }
}