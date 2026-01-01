class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] == 9 && carry != 0){
                digits[i] = 0;
                carry = 1;
            }else{
                digits[i] += carry;
                carry = 0;
            }
        }
        if(carry == 0){
            return digits;
        }else{
            int[] ans = new int[digits.length+1];
            ans[0] = carry;
            for(int i=1;i<ans.length;i++){
                ans[i] = digits[i-1];
            }
            return ans;
        }
    }
}