class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        int oddMax = 0;
        int evenMin = Integer.MAX_VALUE;

        for(int val : freqMap.values()) {
            if(val%2 == 0) {
                evenMin = Math.min(evenMin, val);
            } else {
                oddMax = Math.max(oddMax, val);
            }
        }
        return oddMax - evenMin;
    }
}