class Solution {


    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // System.out.println(map);
        int lengthSoFar = 0;
        int count = 0;
        Map<String, Integer> map2 = new HashMap<>();
        for(String key : map.keySet()) {
            String reverseKey = new StringBuilder(key).reverse().toString();
            if(reverseKey.equals(key)) {
                count++;
                map2.put(key, map.get(key));
                continue;
            }else if(map.containsKey(reverseKey)) {
                int freq2 = map.get(reverseKey);
                int freq1 = map.get(key);
                int minFreq = Math.min(freq1, freq2);
                lengthSoFar += (2 * minFreq) + (2 * minFreq);
                map.put(reverseKey, 0);
            }
            map.put(key, 0);
        }
        boolean allowed = true;
        // System.out.println(map2);
        // System.out.println(count);
        for(String key : map2.keySet()) {
            int freq = map2.get(key);
            if(freq%2 == 1) {
                if(allowed) {
                    lengthSoFar += 2;
                    allowed = false;
                }
            }

            int pairs = freq/2;
            lengthSoFar += (2 * pairs * 2);
        }
        
        return lengthSoFar ;
    }
}