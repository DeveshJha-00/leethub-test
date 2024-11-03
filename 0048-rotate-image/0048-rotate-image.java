class Solution {
    public void rotate(int[][] matrix) {
        // n x n sqaure matrix
        // int n = matrix.length;
        // int rotated[][] = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         rotated[j][n - i - 1] = matrix[i][j];
        //     }
        // }

        //trasnpose and reverse the rows 
        int n = matrix.length;
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                //transpose --> swap (i,j) and (j,i) 
                int temp=0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n/2; j++){
                //reverse rows --> swap (i,j) and (i,n-j-1)
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}