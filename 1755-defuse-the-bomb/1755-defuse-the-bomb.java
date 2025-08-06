class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k==0){
            for (int i=0; i<n; i++) res[i]=0;
        }else if (k>0){
            for (int i=0; i<n; i++){
                int sum=0;
                for(int j=0; j<k; j++){
                    sum += code[(i+j+1)%n];
                }
                res[i]=sum;
            }   
        }else{
            for (int i=0; i<n; i++){
                int sum=0;
                for(int j=n-1; j>=(n+k); j--){
                    sum += code[(j-1+i+1)%n]; // or sum+=code[(j+i)%n]
                }
                res[i]=sum;
            } 
        }
            
        return res;
    }
}