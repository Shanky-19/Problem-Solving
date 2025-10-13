class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        if(words.length == 1) {
            ans.add(words[0]);
            return ans;
        }
        int i = 0;
        int j = i+1;
        int n = words.length;
        while (j < n) {
            while(j<n && isAnagrams(words[i], words[j])) {
                words[j] = "-1";
                j++;
            }
            i = j;
            j++;
        }

        for(String str: words) {
            if(!str.equals("-1")) {
                ans.add(str);
            }
        }
        return ans;
    }

    private boolean isAnagrams(String s1, String s2) {
        Map<Character, Integer> fmap = new HashMap<>();
        for(char ch : s1.toCharArray()) {
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }


        for(char ch : s2.toCharArray()) {
            if(fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch) - 1);
                if(fmap.get(ch) == 0) {
                    fmap.remove(ch);
                }
            } else {
                return false;
            }
        }

        return fmap.isEmpty();
    }
}