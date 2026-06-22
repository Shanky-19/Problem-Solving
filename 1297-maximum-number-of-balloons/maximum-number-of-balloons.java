class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char ch : text.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        int min = Integer.MAX_VALUE;

        if(hm.containsKey('b')) {
            min = Math.min(min, hm.get('b'));
        } else {
            min = 0;
        }

        if(hm.containsKey('a')) {
            min = Math.min(min, hm.get('a'));
        } else {
            min = 0;
        }

        if(hm.containsKey('l')) {
            min = Math.min(min, hm.get('l')/2);
        } else {
            min = 0;
        }

        if(hm.containsKey('o')) {
            min = Math.min(min, hm.get('o')/2);
        } else {
            min = 0;
        }

        if(hm.containsKey('n')) {
            min = Math.min(min, hm.get('n'));
        } else {
            min = 0;
        }
        
        return min;
    }
}