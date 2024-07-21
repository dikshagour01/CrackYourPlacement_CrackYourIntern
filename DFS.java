class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<Integer> traversal = new ArrayList<>();
        dfs(0, adj, vis, traversal);
        return traversal;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> traversal) {
        vis[node] = true;
        traversal.add(node);

        for (int nbr : adj.get(node)) {
            if (!vis[nbr]) {
                dfs(nbr, adj, vis, traversal);
            }
        }
    }
}
