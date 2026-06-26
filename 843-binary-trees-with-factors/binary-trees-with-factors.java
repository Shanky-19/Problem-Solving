class Solution {
    final int mod = (int)(1e9+7);
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);
        Map<Integer, Long> hm = new HashMap<>();
        for(int val: arr) {
            hm.put(val, 1L);
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                int root = arr[i];
                int leftChild = arr[j];
                int rightChild = root/arr[j];
                if(root%arr[j] == 0 && hm.containsKey(rightChild)) {
                    long res = (hm.get(leftChild)*hm.get(rightChild))%mod;
                    long val = hm.get(root);
                    val = (val + res)%mod;
                    hm.put(root, val);
                }
            }
        }
        
        long ans = 0;
        for(Integer x: hm.keySet()) {
            ans = (ans + hm.get(x))%mod;
        }
        return (int)ans;
    }
}