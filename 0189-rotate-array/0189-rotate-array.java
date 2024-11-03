class Solution {
    public void rotate(int[] arr, int k) {
        int []temp = new int[k];
        int n = arr.length;
        k=k%n;

    //     //temp contains the rotated k elements
    //     for(int i=n-k;i<n;i++){
    //         temp[i-(n-k)]=arr[i];
    //     }

    //     //modified arr to have push (n-k) elements to right
    //     for (int i = n-k-1; i >= 0; i--) {
    //         arr[i + k] = arr[i];
    //     }

    //     //put rotated elements back in starting of arr
    //     for (int i=0;i<k;i++){
    //         arr[i]=temp[i];
    //     }

    reverse(arr,0,n-1);
    reverse(arr,0,k-1);
    reverse(arr,k,n-1);
    }
    public void reverse(int[] arr, int a, int b){
        while (a<b){
            int temp = arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
            a++;
            b--;
        }
    }
}