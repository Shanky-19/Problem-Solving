class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
    // Edge case: return an empty list if the input string is empty or the array of words is empty
    if (s.isEmpty() || words.length == 0) {
      return new ArrayList<>();
    }

    // Initialize a list to store the starting indices of the concatenated substrings
    List<Integer> indices = new ArrayList<>();

    // Initialize a map to store the counts of each word in the array of words
    Map<String, Integer> wordCounts = new HashMap<>();
    for (String word : words) {
      wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }

    // Initialize a map to store the counts of each word in the current substring
    Map<String, Integer> currentCounts = new HashMap<>();

    // Initialize variables to keep track of the length of each word and the total length of all the words
    int wordLength = words[0].length();
    int totalLength = wordLength * words.length;

    // Loop through the input string, checking for concatenated substrings at each position
    for (int i = 0; i < s.length() - totalLength + 1; i++) {
      // Initialize the current counts map for the new substring
      currentCounts.clear();

      // Loop through the words in the current substring and update their counts in the current counts map
      for (int j = 0; j < words.length; j++) {
        String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
        currentCounts.put(word, currentCounts.getOrDefault(word, 0) + 1);
      }

      // Check if the current counts map is equal to the original word counts map
      if (currentCounts.equals(wordCounts)) {
        // If they are equal, add the starting index of the current substring to the list of indices
        indices.add(i);
      }
    }

    // Return the list of indices
    return indices;
  }
}