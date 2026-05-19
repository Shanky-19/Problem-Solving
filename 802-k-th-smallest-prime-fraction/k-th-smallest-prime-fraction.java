//Approach-2 (Optimising Approach-1)
//T.C : O((n+k)logn)
//S.C : O(n)
import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));

        for (int i = 0; i < n; i++)
            pq.offer(new double[]{1.0 * arr[i] / arr[n - 1], (double) i, (double) (n - 1)});

        int smallest = 1;

        while (smallest < k) {
            double[] vec = pq.poll();

            int i = (int) vec[1];
            int j = (int) vec[2] - 1;

            pq.offer(new double[]{1.0 * arr[i] / arr[j], (double) i, (double) j});
            smallest++;
        }

        double[] vec = pq.peek();
        int i = (int) vec[1];
        int j = (int) vec[2];
        return new int[]{arr[i], arr[j]};
    }
}