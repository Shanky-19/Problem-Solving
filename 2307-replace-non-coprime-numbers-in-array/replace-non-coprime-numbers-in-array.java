//Approach (Using vector as a stack)
//T.C : O(n * log(x)), where log comes from GCD
//S.C : O(1)
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            // Keep merging while the last number 
            // and current num are non-coprime
            while (!result.isEmpty()) {
                int prev = result.get(result.size() - 1);
                int gcd = gcd(prev, num);

                if (gcd == 1) {
                    break; // coprime, stop merging
                }

                // Remove last and merge with current
                result.remove(result.size() - 1);
                // use long to avoid overflow
                long lcm = ((long) prev / gcd) * num; 
                num = (int) lcm;
            }
            result.add(num);
        }

        return result;
    }

    // Euclidean algorithm for GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}