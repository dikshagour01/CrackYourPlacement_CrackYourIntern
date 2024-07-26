class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) { 
            if (!vis[i]) {
                if (detectCycleUtil(adj, vis, i, -1)) { // Start DFS from the current node i
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean detectCycleUtil(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        
        for (int nbr : adj.get(curr)) {
            // case- 3: Unvisited neighbor
            if (!vis[nbr]) {
                if (detectCycleUtil(adj, vis, nbr, curr)) {
                    return true;
                }
            } 
            
            // case-1: Visited neighbor that is not the parent
            else if (nbr != par) {
                return true;
            }
        }
        return false;
    }
