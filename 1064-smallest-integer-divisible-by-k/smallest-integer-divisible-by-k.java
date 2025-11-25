// class Solution {
//     public int smallestRepunitDivByK(int k) {
//         StringBuilder sb = new StringBuilder();
//         for(int i=0;i<19;i++) {
//             sb.append("1");
//             long val = Long.parseLong(sb.toString());
//             if(val%k == 0) {
//                 return sb.length();
//             }
//         }
//         return -1;
//     }
// }


//Approach - Observation about Modulo(%) values
//T.C : O(k)
//S.C : O(1)
class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K == 1) {
            return 1;
        }
        // Numbers made of only 1s can NEVER be divisible by 2 or 5
        if (K % 2 == 0 || K % 5 == 0){
            return -1;
        }
        int remain = 0;

        for (int length = 1; length <= K; length++) {
            remain = (remain * 10 + 1) % K; // very imp concept

            if (remain == 0) {
                return length;
            }
        }

        return -1;
    }
}

/*
concept used here : 

1 % 7 = 1
11 % 7 = 4
111 % 7 = 6
1111 % 7 = 5
11111 % 7 = 2
111111 % 7 = 0
1111111 % 7 = 1 -> Repeatation starts
11111111 % 7 = 4


instead of creating numbers 11..1 we can use prev remainder 

1 % 7 = 1
[(1 * 10) + 1] % 7 = 4  -> Here 1 is prev remainder
[(4 * 10) + 1] % 7 = 6  -> Here 4 is prev remainder
[(6 * 10) + 1] % 7 = 5  -> Here 6 is prev remainder
[(5 * 10) + 1] % 7 = 2  -> Here 5 is prev remainder
[(2 * 10) + 1] % 7 = 0  -> Here 2 is prev remainder

Length of number is increasing linearly ..
jab tak remainder 0 nahi aata...(length++)

return length


Length can be at max k -> after that repetition will start
*/

