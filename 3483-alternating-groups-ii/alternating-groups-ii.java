// T.C : O(n+k)
// S.C : O(1) (But you can mention you have to add k-1 extra elements so space complexity ideally should be O(k-1))
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int N = n + (k - 1);

        int[] extended = new int[N];
        System.arraycopy(colors, 0, extended, 0, n);
        for (int i = 0; i < k - 1; i++) {
            extended[n + i] = colors[i]; // to handle wrap-around (circular array)
        }

        int result = 0;
        int i = 0, j = 1; // because we have to check index j-1 for checking alternate
        
        while (j < N) {
            if (extended[j] == extended[j - 1]) {
                i = j;
                j++;
                continue;
            }

            if (j - i + 1 == k) {
                result++;
                i++;
            }

            j++;
        }

        return result;
    }
}