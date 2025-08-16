/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private int findPeakIndex (MountainArray mountainArr, int n) {
        int peakIdx = -1;
        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            int currentVal = mountainArr.get(mid);
            int nextVal = Integer.MIN_VALUE;
            if(mid + 1 < n) {
                nextVal = mountainArr.get(mid+1);
            }

            if(currentVal > nextVal) {
                peakIdx = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return peakIdx;

    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIdx = findPeakIndex(mountainArr, n);

        int ans = -1;
        ans = binarySearchLeft(0, peakIdx, mountainArr, target);
        if(ans != -1) {
            return ans;
        }
        ans = binarySearchRight(peakIdx + 1, n-1, mountainArr, target);
        return ans;
    }

    private int binarySearchLeft(
            int low, int high, 
            MountainArray mountainArr, int target) {
        while (low <= high) {
            int mid = low + (high-low)/2;
            int currentVal = mountainArr.get(mid);
            if(currentVal == target) {
                return mid;
            } else if(target < currentVal) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchRight(
            int low, int high, 
            MountainArray mountainArr, int target) {
        // Note : This is decreasing order
        while (low <= high) {
            int mid = low + (high-low)/2;
            int currentVal = mountainArr.get(mid);
            if(currentVal == target) {
                return mid;
            } else if(target < currentVal) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}