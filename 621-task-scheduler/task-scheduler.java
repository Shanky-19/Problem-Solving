class Solution {

    /*   
        ["A","A","A","B","B","B"], k = 2
        A-3
        b-3
        A _ _ A _ _ A
        Number of chunks     = freq('A')-1 = 2
        Number of idle spots = (Number of chunks)*(p) = 2*2 = 4
            
        Now, we will try to fill these 4 idle spots
        If at the end idle spots is 0, it means all idle spots were enough
        to accomodate all other taks. So, out result will be tasks.size();
        
        If, idle spots are not empty, it means that we need more spaces (equal to idle spots)
        than the tasks.size() to accomodate all tasks.
        So, result = tasks.size() + idol_spots
    */

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