class Solution {
    
    class Pair implements Comparable<Pair>{
        double xi;
        double yi;
        
        public Pair(int xi,int yi){
            this.xi = xi;
            this.yi = yi;
        }
        
        public int compareTo(Pair p){
            return (int)(((this.xi)*(this.xi) + (this.yi)*(this.yi)) 
                        - ((p.xi)*(p.xi) + (p.yi)*(p.yi)));
            
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int[] arr : points){
            pq.add(new Pair(arr[0],arr[1]));
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            Pair p = pq.remove();
            ans[i][0] = (int)p.xi;
            ans[i][1] = (int)p.yi;
        }
        return ans;
    }
}