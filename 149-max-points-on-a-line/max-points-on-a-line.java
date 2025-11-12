class Solution {
    public int maxPoints(int[][] points) {
        // y=mx+b;
        // m = y2-y1/x2-x1;
        
         int max =0;
         int n= points.length;
         if(n<2)return n;
        
         for(int i =0 ; i<n ; i++){
          
             for(int j = i+1 ; j<n; j++){
                    int count =2;
                 int x1 = points[i][0] ,x2=points[j][0] , y1 = points[i][1] ,y2 =points[j][1];
                //  int m = (y2-y1)/(x2-x1);
                //  int c = points[j][1]-(m*points[j][0]);
                 for(int k = j+1 ; k<n ; k++){
                      int x3 = points[k][0];
                      int y3 = points[k][1];
                      if (((x2-x1)*(y3-y1)==(x3-x1)*(y2-y1))){
                          count++;
                         
                      }
                 }
                  max = Math.max(max ,count);
             }
         }
         return max;
    }
}