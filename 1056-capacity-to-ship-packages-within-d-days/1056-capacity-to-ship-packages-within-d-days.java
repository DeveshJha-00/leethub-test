class Solution {
    public int func(int[] weights, int capacity){
        int noOfDays=1, totalWeight=0;
        for (int weight : weights){
            if (totalWeight+weight <= capacity){
                totalWeight += weight;
            }else{
                totalWeight=weight;
                noOfDays++;
            }
        }
        return noOfDays;
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE, sum=0;
        for (int weight : weights){
            max = Math.max(max,weight);
            sum += weight;
        }
        int low = max, high = sum;
        while (low < high){
            int mid = low + (high-low)/2;
            int noOfDays = func(weights, mid);
            if (noOfDays <= days) high = mid;
            else low=mid+1;
        }
        return low;
    }
}