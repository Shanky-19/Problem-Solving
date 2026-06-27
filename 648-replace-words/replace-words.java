//Approach (Using normal hashset and generating all substrings)
//T.C : o(n*l + m*l^2) , n = number of words in the dictionary, m be the number of words in the sentence, and l be the average length of each word.
//S.C : O(n*l)
class Solution {
    private String findRoot(String word, Set<String> st) {
        // Try all length substring starting from 0th index
        for (int l = 1; l <= word.length(); l++) {
            String root = word.substring(0, l);
            if (st.contains(root)) {
                return root;
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> st = new HashSet<>(dictionary);
        
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        
        for (String word : words) {
            result.append(findRoot(word, st)).append(" ");
        }
        
        // Remove the trailing space
        return result.toString().trim();
    }
}