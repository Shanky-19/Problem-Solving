class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Map<Character, List<Integer>> characterToItsFirstAndLastIndex = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(characterToItsFirstAndLastIndex.containsKey(ch)){
                List<Integer> firstAndLastIndex = characterToItsFirstAndLastIndex.get(ch);
                firstAndLastIndex.set(1,i);
                characterToItsFirstAndLastIndex.put(ch, firstAndLastIndex);
            }else{
                List<Integer> firstAndLastIndex = new ArrayList<>();
                firstAndLastIndex.add(i);
                firstAndLastIndex.add(-1);
                characterToItsFirstAndLastIndex.put(ch, firstAndLastIndex);
            }
        }
        int ans = 0;
        for(char key : characterToItsFirstAndLastIndex.keySet()){
            List<Integer> firstAndLastIndex = characterToItsFirstAndLastIndex.get(key);
            if(firstAndLastIndex.get(1) > 0){
                Set<Character> uniqueCharsBetweenFirstAndLastIndex = new HashSet<>();
                int firstIndex = firstAndLastIndex.get(0);
                int lastIndex = firstAndLastIndex.get(1);

                for(int i=firstIndex+1;i<=lastIndex-1;i++){
                    uniqueCharsBetweenFirstAndLastIndex.add(s.charAt(i));
                }

                ans += uniqueCharsBetweenFirstAndLastIndex.size();
            }
        }
        return ans;
    }
}