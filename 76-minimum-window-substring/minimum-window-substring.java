class Solution {
    public String minWindow(String s, String t) {
        
        // Brute Force
        /*
        int n = s.length();
        int m = t.length();
        if(n < m) {
            return "";
        }

        int i=0;
        int j=0;
        String ans = "-1";
        while (j < n) {
            int windowSize = j-i+1;
            if(windowSize < m) {
                j++;
            } else {
                boolean isPossible = check(i, j, s, t);
                while(isPossible) {
                    if(ans.equals("-1")) {
                        ans = s.substring(i, j+1);
                    } else {
                        if(j-i+1 < ans.length()) {
                            ans = s.substring(i, j+1);
                        }
                    }
                    i++;
                    isPossible = check(i, j, s, t);
                }
                j++;
            }
        }
        if(ans.equals("-1")) {
            return "";
        }
        return ans;

        */


        int n = s.length();
        int m = t.length();
        if(n < m) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();

        // store karliya
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
            
        int requiredCount = t.length();
        int i = 0, j = 0;

        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;

        // story starts
        while (j < n) {
            char ch = s.charAt(j);

            if (map.containsKey(ch) && map.get(ch) > 0) {
                requiredCount--;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while (requiredCount == 0) {
                // start shrinking the window

                int currWindowSize = j - i + 1;

                if (minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i;
                }

                char startChar = s.charAt(i);
                map.put(startChar, map.getOrDefault(startChar, 0) + 1);

                if (map.containsKey(startChar) && map.get(startChar) > 0) {
                    requiredCount++;
                }

                i++;
            }
            j++;
        }

        return (minWindowSize==Integer.MAX_VALUE) ? "" 
            : s.substring(start_i, start_i + minWindowSize);
    }


    

    /*
    private boolean check (int i, int j, String s, String t) {
        Map<Character, Integer> fmap = new HashMap<>();
        for(char ch : t.toCharArray()) {
            fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
        }

        for(int x=i;x<=j;x++) {
            char ch = s.charAt(x);
            if(fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch)-1);
                if(fmap.get(ch) == 0) {
                    fmap.remove(ch);
                }
            }
        }
        return fmap.isEmpty();
    }
    */
}