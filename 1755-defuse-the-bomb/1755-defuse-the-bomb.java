class Solution {
    public int[] decrypt(int[] arr, int k) {
        int n=arr.length;
        int[] res = new int[n];

        if(k>0){
            int l=1, r=1, i=0, sum=0;
            while(i!=n){
                sum += arr[r];
                if( (r-l+n) % n+1 == k){ //if size is k, mark as soln and move window
                    res[i++]=sum;
                    r=(r+1)%n;
                    sum -= arr[l];
                    l=(l+1)%n;
                }
                else r=(r+1)%n;
            }
            
        }
        else if(k<0){
            int l=n-2, r=n-2 ,i=n-1, sum=0;
            while(i!=-1){
                sum += arr[l];
                if((r - l + n) % n + 1 == Math.abs(k)){
                    res[i--]=sum;
                    l=(l-1+n)%n;
                    sum -= arr[r];
                    r=(r-1+n)%n;
                }
                else l=(l-1+n)%n;
            }
        }

        return res;
    }
}