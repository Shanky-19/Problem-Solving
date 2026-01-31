class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // Linear
        /*
        for(char ch : letters){
            if(ch - target > 0){
                return ch;
            }
        }
        return letters[0];
        */
        // Binary
        int si = 0;
        int ei = letters.length-1;
        while(si <= ei){
            int mid = (si + ei)/2;
            if(letters[mid] > target){
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return letters[si%letters.length];
    }
}