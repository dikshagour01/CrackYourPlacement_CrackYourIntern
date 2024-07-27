class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean vis[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                topSortUtil(adj,i,vis,s);
            }
        }
        
        int result[] = new int[V];
        int i=0;
        while(!s.isEmpty()){
            result[i++]=s.pop();
        }
        
        return result;
    }
    
    public static void topSortUtil(ArrayList<ArrayList<Integer>> adj, int curr, boolean vis[], Stack<Integer> s ){
        vis[curr]=true;
        
        for(int nbr: adj.get(curr)){
            if(!vis[nbr]){
                topSortUtil(adj,nbr,vis,s);
            }
        }
        s.push(curr);
    }
    
}
