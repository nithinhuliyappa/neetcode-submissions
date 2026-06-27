class Solution {
    public void setZeroes(int[][] matrix) {

        boolean firstColZero = false;

        for(int r=0; r<matrix.length; r++){
            if(matrix[r][0] == 0)
                firstColZero = true;
            for(int c=1; c<matrix[0].length; c++){
                if(matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        

        for(int r=matrix.length-1; r>=0; r--){
            for(int c=matrix[0].length-1; c>=1; c--){
                if(matrix[0][c] == 0 || matrix[r][0]==0){
                    matrix[r][c] = 0;
                }
            }

            if(firstColZero){
                matrix[r][0] = 0;
            }
        }
    }
}
