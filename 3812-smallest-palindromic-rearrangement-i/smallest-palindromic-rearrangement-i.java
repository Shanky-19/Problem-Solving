class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        Map<Character, Integer> tmap = new TreeMap<>();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0)+1);
        }

        // System.out.println(tmap);

        char[] ans = new char[n];
        int j = 0;
        for(char ch : tmap.keySet()) {
            int freq = tmap.get(ch);
            while(freq > 1) {
                freq-=2;
                tmap.put(ch, freq);
                ans[j] = ch;
                ans[n-1-j] = ch;
                j++;
            }
            if(freq == 1) {
                ans[n/2] = ch;
            }
        }

        return new String(ans);


    }
}