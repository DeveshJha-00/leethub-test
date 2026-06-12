class TreeAncestor {
    private int[][] ancestorTable;
    private int cols;

    public TreeAncestor(int n, int[] parent) {
        cols = (int)(Math.log(n) / Math.log(2)) + 1;
        ancestorTable = new int[n][cols]; //define table

        for (int[] r : ancestorTable) Arrays.fill(r, -1); //fill with -1

        for (int node=0; node<n; node++){ //initialize first col
            ancestorTable[node][0] = parent[node];
        }

        for (int j=1; j<cols; j++){
            for (int node=0; node<n; node++){
                int prev = ancestorTable[node][j-1];
                if (prev != -1)
                    ancestorTable[node][j] = ancestorTable[prev][j-1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {

        for (int j=0; j<cols; j++){
            if ((k & (1 << j)) != 0){
                node = ancestorTable[node][j];
                if (node == -1) return -1;
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */