class Solution {
    public void setZeroes(int[][] matrix) {
        // int col[m] = {0}; --> matrix[0][..]
        // int row[n] = {0}; --> matrix[..][0]
        int n = matrix.length;
        int m = matrix[0].length;
        int col0=1;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (matrix[i][j] == 0){
                    //mark the i-th row
                    matrix[i][0] = 0;
                    //mark the j-th column
                    if (j != 0) matrix[0][j]=0;
                    else col0=0;
                }
            }
        }

        //check all exept 1st row and 1st column
        for (int i=1; i<n; i++){
            for (int j=1; j<m; j++){
                if (matrix[i][j] != 0){
                    if (matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j]=0;
                    }
                }
            }
        }

        //check 1st column elements first bcz they are dependent on 1st row element
        //if we check 1st row elements first and change them(if), it will affect the column
        if (matrix[0][0] == 0){
            for (int j=0;j<m;j++)
                matrix[0][j]=0;
        }

        if (col0==0){
            for (int i=0; i<n; i++)
                matrix[i][0]=0;
        }
    }
}