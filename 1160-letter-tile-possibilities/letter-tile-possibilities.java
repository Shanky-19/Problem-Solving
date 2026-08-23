// Approach-2 (Using count of characters + backtracking)
// T.C : O(n!)
// S.C : O(n), total possible sequences = n! and each having n length
class Solution {
    private int total;

    private void findSequences(int[] count) {
        total++;

        for (int pos = 0; pos < 26; pos++) {
            if (count[pos] == 0) {
                continue;
            }

            count[pos]--;
            findSequences(count);
            count[pos]++;
        }
    }

    public int numTilePossibilities(String tiles) {
        total = 0;

        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }

        findSequences(count);
        return total - 1;
    }
}