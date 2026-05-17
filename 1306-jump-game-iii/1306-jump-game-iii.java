class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return solve(arr, start, visited);
    }

    private boolean solve(int[] arr, int idx, boolean[] visited){
        if (arr[idx] == 0) return true;

        int n = arr.length;
        visited[idx] = true;
        int op1Idx = idx + arr[idx];
        int op2Idx = idx - arr[idx];

        boolean op1 = false;
        boolean op2 = false;
        if (op1Idx < n && !visited[op1Idx]){
            op1 = solve(arr, op1Idx, visited);
        }
        if (op2Idx >=0 && !visited[op2Idx]){
            op2 = solve(arr, op2Idx, visited);
        }

        visited[idx] = false;
        
        return op1 || op2;
    }
}