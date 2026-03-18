class Solution {


    class Pair{
        int node;
        int time; // time taken by news to reach this node

        public Pair(int node,int time){
            this.node = node;
            this.time = time;
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            int mgr = manager[i];
            if(mgr != -1){
                graph.get(mgr).add(i);
            }
        }

        // System.out.println(graph);

        // BFS
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(headID,0));
        int maxTime = Integer.MIN_VALUE;
        while(queue.size() > 0){
            int size = queue.size();
            while(size-- > 0){
                // r m* w a*
                Pair p = queue.removeFirst();
                int front = p.node;
                int time = p.time;

                maxTime = Math.max(maxTime,time);

                for(int nbr : graph.get(front)){
                    queue.addLast(new Pair(nbr,time + informTime[front]));
                }
            }
        }
        return maxTime;

    }
}