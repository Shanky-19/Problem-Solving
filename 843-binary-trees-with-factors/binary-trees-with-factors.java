class Solution {
    final int mod = (int)(1e9+7);
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> hmp = new HashMap<>();
        for(int x: arr)
            hmp.put(x, 1L);
        
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int prod = arr[i];
                int x1 = arr[j], x2 = prod/arr[j];
                if(prod%arr[j] == 0 && hmp.containsKey(x2))
                {
                    long res = (hmp.get(x1)*hmp.get(x2))%mod;
                    long val = hmp.get(prod);
                    val = (val + res)%mod;
                    hmp.put(prod, val);
                }
            }
        }
        
        long ans = 0;
        for(Integer x: hmp.keySet())
            ans = (ans + hmp.get(x))%mod;
        
        return (int)ans;
    }
}