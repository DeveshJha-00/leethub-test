class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives=0, tens=0;
        for (int amt:bills){
            if (amt==5) fives++;
            else if (amt==10){
                if (fives==0) return false;
                fives--;
                tens++;
            }else{
                if (tens>0 && fives>0){
                    tens--;
                    fives--;
                }else if (fives >= 3) fives-=3;
                else return false;
            }
        }

        return true;
    }
}