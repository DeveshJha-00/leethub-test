// class Solution {
//     public char kthCharacter(long k, int[] operations) {
//         StringBuilder word = new StringBuilder("a");
//         if (k==0) return 'a';
//         int ptr = 0;

//         while (word.length() < k){
//             int wordLen = word.length();
//             int op = operations[ptr++];
            
//             if (op==0) word.append(word);
//             else{
//                 for (int i=0; i<wordLen; i++){
//                     int oldCharVal = word.charAt(i) - 'a';
//                     char newChar = (char)((oldCharVal + 1) % 26 + 'a');
//                     word.append(newChar);
//                 }
//             }
//         }
//         return word.charAt((int)(k-1));
//     }
// }

class Solution {
    public char kthCharacter(long k, int[] operations) {
        if (k == 1) return 'a';

        int n = operations.length;
        int opType = -1;
        long newK = k;
        long len = 1;

        for (int i=0; i<n; i++){
            len *= 2;
            if (len >= k){
                opType = operations[i];
                newK = k - len/2;
                break;
            }
        }

        char prevChar = kthCharacter(newK, operations);

        if (opType == 0) return prevChar;
        else{
            if (prevChar == 'z') return 'a';
            return (char)(prevChar + 1);
        }
    }
}