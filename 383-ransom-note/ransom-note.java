class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] fmap1 = new int[26];
        int[] fmap2 = new int[26];
        
        for(char ch : ransomNote.toCharArray()){
            fmap1[ch-'a']++;
        }
        
        for(char ch : magazine.toCharArray()){
            fmap2[ch-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(fmap1[i]>fmap2[i]){
                return false;
            }
        }
        return true;
    }
}