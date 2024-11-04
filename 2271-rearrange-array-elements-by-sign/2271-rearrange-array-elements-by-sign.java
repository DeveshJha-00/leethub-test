class Solution {

    // public void swap (int[] arr, int a, int b){
    //     int temp = arr[a];
    //     arr[a] = arr[b];
    //     arr[b] = temp;
    // }

    public int[] rearrangeArray(int[] nums) {
        // int n = nums.length;
        // List<Integer> posArr = new ArrayList<>();
        // List<Integer> negArr = new ArrayList<>();

        // for (int ele : nums){
        //     if (ele > 0) posArr.add(ele);
        //     else negArr.add(ele);
        // }

        // int p1=0, p2=0, i=0;
        // while (p1<n/2 || p2<n/2){
        //     nums[i++] = posArr.get(p1++);
        //     nums[i++] = negArr.get(p2++);
        // }


        // int p1=0,p2=1;
        // if (nums[0] < 0){
        //     for (int i=1;i<n;i++){
        //         if (nums[i] > 0){
        //             swap(nums,0,i);
        //             break;
        //         }
        //     }
        // }

        // while (p2<n){
        //     if (nums[p1]*nums[p2] > 0){ //if same sign
        //         while (nums[p1]*nums[p2] > 0){
        //             p2++;
        //         }
        //         swap(nums,p1+1,p2);
        //         p1 += 2;
        //         p2++;
        //     }else{
        //         p1 += 2;
        //         p2 += 2;
        //     }
        // }

        // return nums;

        int n = nums.length;
        int ans[] = new int[n];
        int posIndex=0;
        int negIndex=1;
        for (int i=0;i<n;i++){
            if (nums[i] >=0 ){
                ans[posIndex] = nums[i];
                posIndex+=2;
            }else{
                ans[negIndex] = nums[i];
                negIndex+=2;
            }
        }
        return ans;

    }
    
}