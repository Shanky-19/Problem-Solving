//Approach-1 (Brute Force)
//T.C : O(m*n)
//S.C : O(1)
class Solution {
    public String removeOccurrences(String s, String part) {
        // s.length() = m
        // part.length() = n;
        // O(m*n)
        while (true) {
            int idx = s.indexOf(part);

            if (idx == -1) {
                break;
            }

            s = s.substring(0, idx) + s.substring(idx + part.length());
        }

        return s;
    }
}