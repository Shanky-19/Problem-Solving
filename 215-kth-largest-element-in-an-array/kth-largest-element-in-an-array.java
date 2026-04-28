//Approach-3 (Using QuickSelect Algorithm)
//Time complexity: O(n) on average, 
// O(n2) in the worst case 
class Solution {
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
    public int partition_algo(int[] nums, int L, int R) {
        
        int P = nums[L];
        int i = L+1; //0
        int j = R; //0
        
        while(i <= j) {
            
            if(nums[i] < P && nums[j] > P) {
                swap(nums, i, j);
                i++;
                j--;
            }
            
            if(nums[i] >= P) {
                i++;
            }
            
            if(nums[j] <= P) {
                j--;
            }
            
        }
        
        // abhi jo j idx hai uske left
        // me sare bade elements hai
        // aur right me sare chote 

        swap(nums, L, j);
        return j; //P is at jth index
    }
    
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int L = 0;
        int R = n-1;
        int pivot_idx = 0;
        
        //kth largest pivot element - nums[k-1] 
        // (descendinforder me partition karenge)
        
        while(true) {
            
            pivot_idx = partition_algo(nums, L, R);
            
            if(pivot_idx == k-1) {
                break;
            } else if(pivot_idx > k-1) { //2nd larget , 4th larget
                R = pivot_idx - 1;
            } else {
                L = pivot_idx + 1;
            }
        }  
        return nums[pivot_idx];
    }
}