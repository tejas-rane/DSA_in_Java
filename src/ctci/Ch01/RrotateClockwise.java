package ctci.Ch01;

public class RrotateClockwise {
	public static void rotate(int[][] matrix) {
        int n = matrix[0].length-1;
        for(int i = 0 ; i< (n/2)+1; i++){
            for(int j = i; j< n-i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j]=matrix[j][n-i];
                matrix[j][n-i] = temp;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]
				{
			{ 1, 2, 3,4},
				  {5, 6, 7,8},
				  {9, 10, 11, 12},
				  {13,14,15,16}
				}; 
				for(int i = 0 ; i<= 3; i++){
					for(int j = 0 ; j<= 3; j++){
						System.out.print(matrix[i][j]+ "  ");
					}
					System.out.println();
				}
				System.out.println();
				rotate(matrix);
				for(int i = 0 ; i<= 3; i++){
					for(int j = 0 ; j<= 3; j++){
						System.out.print(matrix[i][j]+ "  ");
					}
					System.out.println();
				}
	}

}
