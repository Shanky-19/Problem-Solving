class Solution {
    public int countTriples(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int sq = i*i + j*j;
                int k = (int)Math.sqrt(sq);
                
                if(k*k == sq && k <= n){
                    answer += 2; // becoz (i,j,k) and (j,i,k) are different
                }
            }
        }
        return answer;
    }
}