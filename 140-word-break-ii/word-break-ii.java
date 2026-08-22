class Solution {

    public void helper(String s,Set<String> set,
                        StringBuilder sb,List<String> ans){
        if(s.length() == 0){
            // to remove extra space which is added at last
            sb.deleteCharAt(sb.length()-1); 
            ans.add(sb.toString());
            return;
        }

        // we have to make a cut
        for(int i=0;i<s.length();i++){
            String prefix = s.substring(0,i+1);
            String remainingString = s.substring(i+1);
            if(set.contains(prefix)){
                // as we cannot remove from sb the 
                // last prefix added we have to use temp for backtracking
                StringBuilder temp = new StringBuilder(sb);
                temp.append(prefix+" ");
                helper(remainingString,set,temp,ans);
            }
        }

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String word: wordDict){
            set.add(word);
        }
        StringBuilder sb = new StringBuilder();
        helper(s,set,sb,ans);
        return ans;
    }
}