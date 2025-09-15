class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for(char ch : brokenLetters.toCharArray()) {
            set.add(ch);
        }
        String[] arr = text.split(" ");
        int ans = 0;
        for(String s : arr) {
            boolean skip = false;
            for(char ch : s.toCharArray()) {
                if (set.contains(ch)) {
                    skip = true;
                    break;
                }
            }
            if(!skip) {
                ans++;
            }
        }
        return ans;
    }
}