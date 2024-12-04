class Solution {
    public int romanToInt(String s) {
        // int ans=0;
        // for (int i=0; i<=s.length()-1; i++){

        //     switch(s.charAt(i)){
        //         case 'I' : 
        //             if ( ((i+1)<=s.length()-1) && s.charAt(i+1)=='V'){
        //                 ans-=1;
        //             }else if (((i+1)<=s.length()-1) && s.charAt(i+1)=='X'){
        //                 ans-=1;
        //             }else{
        //                 ans+=1;
        //             }
        //             break;

        //         case 'V' : ans+=5;
        //         break;

        //         case'X' : if (((i+1)<=s.length()-1) && s.charAt(i+1)=='L'){
        //             ans-=10;
        //         }else if (((i+1)<=s.length()-1) && s.charAt(i+1)=='C'){
        //             ans-=10;
        //         }else{
        //             ans+=10;
        //         }
        //         break;

        //         case'L' : ans+=50;
        //         break;

        //         case'C' : if (((i+1)<=s.length()-1) && s.charAt(i+1)=='D'){
        //             ans-=100;
        //         }else if (((i+1)<=s.length()-1) && s.charAt(i+1)=='M'){
        //             ans-=100;
        //         }else{
        //             ans+=100;
        //         }
        //         break;

        //         case 'D' : ans+=500;
        //         break;

        //         case 'M' : ans+=1000;
        //         break;
        //     }
        // }
        
        // return ans;



        HashMap<Character, Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res=0, pre=0;
        for(int i=s.length()-1; i>=0; i--){
            if(map.get(s.charAt(i))>=pre){
                res+=map.get(s.charAt(i));
            }else{
                res-=map.get(s.charAt(i));
            }
            pre=map.get(s.charAt(i));
        }
        return res;
    }
}