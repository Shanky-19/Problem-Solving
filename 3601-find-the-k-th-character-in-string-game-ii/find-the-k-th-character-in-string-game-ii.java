// class Solution {
//     public char kthCharacter(long k, int[] operations) {
//         StringBuilder sb = new StringBuilder();
//         sb.append('a');
//         for(int op : operations) {
//             if(sb.length() >= k) {
//                 // small optimization
//                 break;
//             }
//             if(op == 0) {
//                 sb.append(sb);
//             } else {
//                 StringBuilder sb2 = new StringBuilder();
//                 for(int i=0;i<sb.length();i++) {
//                     char ch = sb.charAt(i);
//                     if(ch == 'z') {
//                         ch = 'a';
//                     } else {
//                         ch = (char) (((ch-'a') + 1) + 'a');
//                     }
//                     sb2.append(ch);
//                 }
//                 sb.append(sb2);
//             }
//         }
//         // System.out.println(sb);
//         if(k > Integer.MAX_VALUE) {
//             sb = new StringBuilder(sb.toString().substring(Integer.MAX_VALUE));
//             k -= Integer.MAX_VALUE;
//             return sb.charAt((int)k-1);
//         } else {
//             return sb.charAt((int)k-1);
//         }
//     }
// }



class Solution {
    public char kthCharacter(long k, int[] operations) {
        int shift = 0; // total number of +1 (mod 26) operations
        List<Long> lengths = new ArrayList<>();
        long len = 1;

        for (int op : operations) {
            len *= 2;
            lengths.add(len);
            if (len >= k) break;
        }

        for (int i = lengths.size() - 1; i >= 0; i--) {
            long half = lengths.get(i) / 2;
            int op = operations[i];

            if (k > half) {
                k -= half;
                if (op == 1) shift++;
            }
            // else: k remains the same
        }

        // Apply total shift from 'a'
        return (char) ((('a' - 'a' + shift) % 26) + 'a');
    }
}