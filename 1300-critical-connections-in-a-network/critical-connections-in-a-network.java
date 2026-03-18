class Solution {

    int timer = 1;
    // Tarjan's Algo
    public void dfs(int src,int parent,boolean[] visited,int[] tin,int[] low,
                    ArrayList<ArrayList<Integer>> graph,List<List<Integer>> bridges){

        visited[src] = true;
        tin[src] = low[src] = timer;
        timer++;

        for(int nbr : graph.get(src)){
            if(nbr == parent){
                continue;
            }

            if(!visited[nbr]){
                dfs(nbr,src,visited,tin,low,graph,bridges);
                low[src] = Math.min(low[src],low[nbr]);

                if(low[nbr] > tin[src]){
                    bridges.add(Arrays.asList(nbr,src));
                }
            }else{
                low[src] = Math.min(low[src],low[nbr]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> edge : connections){
            int s = edge.get(0);
            int e = edge.get(1);

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        boolean[] visited = new boolean[n];
        int[] tin = new int[n]; // time of insertion
        int[] low = new int[n]; // min lowest time insertion of all adjacent nodes apart from parent
        int vertex = 0;
        int parent = -1;
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(vertex,parent,visited,tin,low,graph,bridges);
        return bridges;
    }
}