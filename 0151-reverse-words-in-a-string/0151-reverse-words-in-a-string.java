class Solution {
    public void swap(String[] arr, int a, int b){
        String temp = arr[a];
        arr[a++]=arr[b];
        arr[b--]=temp;
        // a++;
        // b--;
    }
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int i=0;
        int j=arr.length-1;
        while (i<j){
            swap(arr,i++,j--);
            // i++;
            // j--;
        }
        // String newstr = String.join(" ",arr);
        // return newstr.replaceAll(" +"," ").trim();
        return String.join(" ",arr).replaceAll(" +"," ").trim();
    }
}

// class Solution {
//     public String reverseWords(String s) {
//         String words[]=s.trim().split("\\s+");
//         StringBuilder reversed=new StringBuilder();

//         for(int i=words.length-1;i>=0;i--){
//             reversed.append(words[i]);
//             if(i!=0){
//                 reversed.append(" ");
//             }
//         }
//         return reversed.toString();
// }
// }