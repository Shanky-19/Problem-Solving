class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        // Set<Integer> ors = new HashSet<>();
        // int i = 0;
        // while(i < n) {
        //     int currentOr = arr[i];
        //     int j = i;
        //     while(j < n) {
        //         currentOr = currentOr | arr[j];
        //         ors.add(currentOr);
        //         j++;
        //     }
        //     i++;
        // }
        // return ors.size();

        Set<Integer> prev = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        
        for(int i=0;i<n;i++) {
            for(int x : prev) { // prev can at max 32 (32 bits can 1 at max)
                curr.add(x | arr[i]);
                result.add(x | arr[i]);
            }

            curr.add(arr[i]);
            result.add(arr[i]);

            prev = curr;
            curr = new HashSet<>();
        }
        return result.size();
    }
}
