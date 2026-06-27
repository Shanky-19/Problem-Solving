class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char ch : word.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                        Collections.reverseOrder());

        for(char ch : hm.keySet()) {
            pq.add(hm.get(ch));
        }
        // System.out.println(pq);

        int currButton = 2;
        int currPush = 1;
        int pushes = 0;
        while(pq.size() > 0) {
            if(currButton > 9) { // 2..9 -> 8 buttons
                currButton = 2;
                currPush++;
            }
            int freq = pq.remove();
            pushes += (currPush * freq);
            currButton++;
        }
        return pushes;
    }
}