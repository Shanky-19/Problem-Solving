class Solution {

    static class Pair {
        long sum;
        int left;
        int right;

        Pair(long sum, int left, int right) {
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        if (n <= 1) return 0;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            alive[i] = true;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
            return Integer.compare(a.left, b.left);
        });

        int badPairs = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                badPairs++;
            }

            pq.add(new Pair(arr[i] + arr[i + 1], i, i + 1));
        }

        int operations = 0;

        while (badPairs > 0) {
            Pair curr = pq.poll();

            int left = curr.left;
            int right = curr.right;

            // Skip invalid pair
            if (!alive[left] || !alive[right] || next[left] != right) {
                continue;
            }

            // Important: skip stale pair with old sum
            if (curr.sum != arr[left] + arr[right]) {
                continue;
            }

            int leftPrev = prev[left];
            int rightNext = next[right];

            // Remove old bad pair contribution
            if (leftPrev >= 0 && arr[leftPrev] > arr[left]) {
                badPairs--;
            }

            if (arr[left] > arr[right]) {
                badPairs--;
            }

            if (rightNext < n && arr[right] > arr[rightNext]) {
                badPairs--;
            }

            // Merge right into left
            arr[left] += arr[right];
            alive[right] = false;

            next[left] = rightNext;

            if (rightNext < n) {
                prev[rightNext] = left;
            }

            // Add new bad pair contribution
            if (leftPrev >= 0 && arr[leftPrev] > arr[left]) {
                badPairs++;
            }

            if (rightNext < n && arr[left] > arr[rightNext]) {
                badPairs++;
            }

            // Add newly formed adjacent pairs
            if (leftPrev >= 0) {
                pq.add(new Pair(arr[leftPrev] + arr[left], leftPrev, left));
            }

            if (rightNext < n) {
                pq.add(new Pair(arr[left] + arr[rightNext], left, rightNext));
            }

            operations++;
        }

        return operations;
    }
}