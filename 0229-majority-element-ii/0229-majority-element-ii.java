class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        // HashMap<Integer,Integer> map = new HashMap<>();
        // int n = nums.length;
        // int mini= (int)(n/3) + 1;
        // for (int ele:nums){
        //     map.put(ele, map.getOrDefault(ele,0)+1);
        //     if (map.get(ele) == mini){
        //         list.add(ele);
        //     }
        //     // if (list.size() == 2) break; --> NOT NEEDED, JUST OPTIMIZES FUTHER
        // }
        // return list;

        int cnt1=0, cnt2=0;
        int ele1=-1, ele2=-1;
        for (int i=0; i<nums.length; i++){
            if (cnt1==0 && nums[i]!=ele2){
                ele1 = nums[i];
                cnt1 = 1;
            }
            else if (cnt2==0 && nums[i]!=ele1){
                ele2 = nums[i];
                cnt2 = 1;
            }
            else if (nums[i] == ele1) cnt1++;
            else if (nums[i] == ele2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        //manual check at the end if ele1 and ele 2 actually appear more than n/3 times
        cnt1=0; cnt2=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == ele1) cnt1++;
            if (nums[i] == ele2) cnt2++;
        }

        int mini = (int)(nums.length / 3) + 1;
        if (cnt1 >= mini) list.add(ele1);
        if (cnt2 >= mini && ele1!=ele2) list.add(ele2);

        return list;
    }
}