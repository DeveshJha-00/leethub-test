class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return solve(arr, start, visited);
    }

    private boolean solve(int[] arr, int idx, boolean[] visited){
        int n = arr.length;
        if (idx<0 || idx>=n || visited[idx]){
            return false;
        }

        if (arr[idx] == 0) return true;

        visited[idx] = true;
        boolean op1 = solve(arr, idx+arr[idx], visited);
        boolean op2 = solve(arr, idx-arr[idx], visited);

        return op1 || op2;
    }
}