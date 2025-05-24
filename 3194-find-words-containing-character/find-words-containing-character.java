class Solution {

    public boolean contains(String word, char x) {
        for(char ch : word.toCharArray()) {
            if(ch == x) {
                return true;
            }
        }
        return false;
    }
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
            String word = words[i];
            if(contains(word, x)) {
                ans.add(i);
            }
        }
        return ans;
    }
}