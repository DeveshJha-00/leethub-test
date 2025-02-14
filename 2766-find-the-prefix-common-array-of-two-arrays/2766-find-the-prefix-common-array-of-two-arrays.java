class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;        
        int[] C = new int[n];
        int common=0;
        int[] hashA = new int[n+1];
        int[] hashB = new int[n+1];
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