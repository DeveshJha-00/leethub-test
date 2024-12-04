class Solution {
    public int romanToInt(String s) {
        int ans=0;

        for (int i=0; i<=s.length()-1; i++){

            switch(s.charAt(i)){
                case 'I' : 
                    if ( ((i+1)<=s.length()-1) && s.charAt(i+1)=='V'){
                        ans-=1;
                    }else if (((i+1)<=s.length()-1) && s.charAt(i+1)=='X'){
                        ans-=1;
                    }else{
                        ans+=1;
                    }
                    break;

                case 'V' : ans+=5;
                break;

                case'X' : if (((i+1)<=s.length()-1) && s.charAt(i+1)=='L'){
                    ans-=10;
                }else if (((i+1)<=s.length()-1) && s.charAt(i+1)=='C'){
                    ans-=10;
                }else{
                    ans+=10;
                }
                break;

                case'L' : ans+=50;
                break;

                case'C' : if (((i+1)<=s.length()-1) && s.charAt(i+1)=='D'){
                    ans-=100;
                }else if (((i+1)<=s.length()-1) && s.charAt(i+1)=='M'){
                    ans-=100;
                }else{
                    ans+=100;
                }
                break;

                case 'D' : ans+=500;
                break;

                case 'M' : ans+=1000;
                break;
            }
        }
        
        return ans;
    }
}