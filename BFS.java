class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        ArrayList<Integer> traversal = new ArrayList<>();
        
        q.add(0);
        vis[0] = true; // Mark the starting node as visited

        while (!q.isEmpty()) {
            int curr = q.poll(); // Use poll instead of remove for queue
            traversal.add(curr);

            for (int nbr : adj.get(curr)) {
                if (!vis[nbr]) {
                    q.add(nbr);
                    vis[nbr] = true; // Mark as visited when added to the queue
                }
            }
        }
        return traversal;
    }
    
}
