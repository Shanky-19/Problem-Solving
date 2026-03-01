class Solution {
    public int minPartitions(String n) {
        int maxDigit = Integer.MIN_VALUE;
        
        for(char ch : n.toCharArray()){
            if((ch - '0') > maxDigit){
                maxDigit = ch - '0';
            }
        }
        
        return maxDigit;
    }
}