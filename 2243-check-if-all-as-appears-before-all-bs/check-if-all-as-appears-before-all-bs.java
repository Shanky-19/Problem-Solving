class Solution {
    public boolean checkString(String s) {
        boolean isViolated = false;
        boolean isBEncountered = false;
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);

            if(isBEncountered && ch == 'a') {
                return false;
            }
            if(ch == 'b') {
                isBEncountered = true;
            } 
            i++;
        }
        return true;
    }
}