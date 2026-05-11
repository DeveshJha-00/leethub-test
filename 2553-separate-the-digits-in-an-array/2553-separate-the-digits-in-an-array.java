class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums){
            List<Integer> rev = new ArrayList<>();
            while(num > 0){
                rev.add(num % 10);
                num /= 10;
            }
            for (int i=rev.size()-1; i>=0; i--){
                arr.add(rev.get(i));
            }
        }

        int[] res = new int[arr.size()];
        for (int i=0; i<arr.size(); i++){
            res[i] = arr.get(i);
        }

        return res;
    }
}