class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, 
                                        int[] rightChild) {
        Map<Integer, Integer> childToParent = new HashMap<>();

        // 1. Every child should have only 1 parent
        for(int i=0;i<n;i++) {
            int left = leftChild[i];
            if(left != -1) {
                if(childToParent.containsKey(left)) {
                    return false;
                }
                childToParent.put(left, i);
            }

            int right = rightChild[i];
            if(right != -1) {
                if(childToParent.containsKey(right)) {
                    return false;
                }
                childToParent.put(right, i);
            }
        }

        // 2. Tree Should have only 1 root
        int count = 0;
        int root = -1; 
        for(int i=0;i<n;i++) {
            if(!childToParent.containsKey(i)) {
                count++;
                root = i;
            }
        }
        if(count > 1 || root == -1) {
            return false;
        }

        // 3. Only 1 connected component -> in one DFS 
        // or BFS entire tree should be visited
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        boolean[] visited = new boolean[n];
        while(q.size() > 0) {
            int front = q.poll();

            visited[front] = true;

            if(leftChild[front] != -1 && !visited[leftChild[front]]) {
                q.offer(leftChild[front]);
            }

            if(rightChild[front] != -1 && !visited[rightChild[front]]) {
                q.offer(rightChild[front]);
            }
        }

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;

    }
}