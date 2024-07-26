class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int col[] = new int[V];
        for(int i=0; i<col.length; i++){
            col[i]=-1;  //assign -1 means no color
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<adj.size(); i++){
            if(col[i]==-1){
                col[i]=0;
                q.add(i);
            }
            
            while(!q.isEmpty()){
                int curr = q.remove();
                for(int nbr: adj.get(curr)){
                    if(col[nbr]==-1){
                        int nextCol=col[curr]==0 ? 1:0;
                        col[nbr]=nextCol;
                        q.add(nbr);
                    }
                    else if(col[nbr]==col[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
