class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");

        while(sb.length() < k) {
            int n = sb.length();
            StringBuilder sb2 = new StringBuilder();
            for(char ch : sb.toString().toCharArray()) {
                char nextChar = ch == 'z' ? 'a' : (char) ((ch - 'a') + 1 + 'a');
                sb2.append(nextChar);
            }
            sb.append(sb2);
        }

        return sb.charAt(k-1);
    }
}