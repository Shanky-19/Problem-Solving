class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks) {
            freq[ch-'A']++;
        }

        Arrays.sort(freq);
        int chunks = freq[25] - 1;
        int idleSpots = (chunks*n);

        for(int i=24;i>=0;i--) {
            idleSpots -= Math.min(chunks, freq[i]);
        }

        if(idleSpots > 0) {
            return tasks.length + idleSpots;
        }
        return tasks.length;
    }
}