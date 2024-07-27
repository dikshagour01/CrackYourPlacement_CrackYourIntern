class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        boolean stack[] = new boolean[V];
        
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                if(isCyclicUtil(adj,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, int curr, boolean vis[], boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;
        
        for(int nbr: adj.get(curr)){
            if(stack[nbr]==true){
                return true;
            }
            else if (!vis[nbr] && isCyclicUtil(adj,nbr,vis,stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
}
