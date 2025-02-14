class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        // if (n==1) return new int[0];
        
        int[] C = new int[n];
        int common=0;
        int[] hashA = new int[51];
        int[] hashB = new int[51];
        for (int i=0; i<n; i++){
            hashA[A[i]]=1;
            hashB[B[i]]=1;
            if (A[i] == B[i]){
                common++;
            }else{
                if (hashA[B[i]]==1) common++;
                if (hashB[A[i]]==1) common++;
            }
            C[i] = common;
        }
        

        return C;
    }
}