class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] fmap = new int[26];
        for(char ch : text.toCharArray()){
            fmap[ch-'a']++;
        }
        // a=0 b=1 l=11 o=14 n=13
        int a=fmap[0];
        int b=fmap[1];
        int l=fmap[11];
        int o=fmap[14];
        int n=fmap[13];
        
        int count=0;
        while( b>0 && a>0 && l>1 && o>1 && n>0){
                count+=1;
                b--; a--; l-=2 ; o-=2; n--;       
        }
        return count;
    }
}