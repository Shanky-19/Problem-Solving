class Solution {
    public boolean rotateString(String s, String goal) {
        
        int[] fmap1 = new int[26];
        int[] fmap2 = new int[26];
        for(char ch : s.toCharArray()){
            fmap1[ch - 'a']++;
        }
        for(char ch : goal.toCharArray()){
            fmap2[ch - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(fmap1[i] != fmap2[i]){
                return false;
            }
        }
        
        
        s = s + s;
        return s.contains(goal);
        
    }
}