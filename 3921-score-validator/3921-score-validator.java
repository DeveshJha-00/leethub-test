class Solution {
    public int[] scoreValidator(String[] events) {
        int score=0, counter=0;
        for (String e : events){
            if (Character.isDigit(e.charAt(0))) score += e.charAt(0) - '0';
            else if (e.equals("WD") || e.equals("NB")) score++;
            else counter++;
            if (counter == 10) break;
        }

        return new int[]{score, counter};
    }
}