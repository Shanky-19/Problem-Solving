class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> hm = new HashMap<>();
        int currPush = 1;
        int currButton = 2;
        int pushes = 0;
        for(char ch : word.toCharArray()) {
            // if(hm.containsKey(ch)) {
            //     pushes += hm.get(ch);
            // } else {
                if(currButton == 10) {
                    currButton = 2;
                    currPush++;
                }
                currButton++;
                hm.put(ch, currPush);
                pushes += hm.get(ch);
            // }
        }
        return pushes;

    }
}