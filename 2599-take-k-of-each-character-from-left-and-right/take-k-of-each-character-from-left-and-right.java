class Solution {
    public int takeCharacters(String s, int k) {
        Map<Character, Integer> deletedMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            deletedMap.put(ch, deletedMap.getOrDefault(ch, 0) + 1);
        }

        if(deletedMap.getOrDefault('a', 0) < k 
            || deletedMap.getOrDefault('b', 0) < k 
            || deletedMap.getOrDefault('c', 0) < k) {
            return -1;
        }

        int i = 0;
        int j = 0;
        int n = s.length();
        int windowLength = 0;
        while (j < n) {
            char ch = s.charAt(j);
            deletedMap.put(ch, deletedMap.get(ch)-1);
            if(deletedMap.get(ch) < k) {
                while (i <= j && deletedMap.get(ch) < k) {
                    char frontChar = s.charAt(i);
                    deletedMap.put(frontChar, deletedMap.get(frontChar) + 1);
                    i++;
                }
            }
            windowLength = Math.max(windowLength, j-i+1);
            j++;
        }
        return (n - windowLength);
    }
}