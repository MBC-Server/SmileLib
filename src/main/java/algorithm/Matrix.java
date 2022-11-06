package algorithm;

public class Matrix { // 稀疏矩陣，減少記憶體使用量的矩陣 每層矩陣代表一個數值，每個數值都有一個位置，位置由x,y座標決定

    public static int [][] transform(int [][] matrix) { // 轉置矩陣
        int sum = 0; // 找到所有非0數值的個數
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt != 0) sum++;
            }
        }
         int[][] sparseArr = new int[sum+1][3]; // 建立稀疏矩陣
            sparseArr[0][0] = matrix.length; // 第一行為原始矩陣的大小
            sparseArr[0][1] = matrix[0].length;
            sparseArr[0][2] = sum;
            int count = 0; // 將非0數值放入稀疏矩陣
            for(int i=0;i< matrix.length;i++){
                for(int j=0;j< matrix[i].length;j++){
                    if(matrix[i][j] !=0){
                        count++;
                        sparseArr[count][0] = i;
                        sparseArr[count][1] = j;
                        sparseArr[count][2] = matrix[i][j];
                    }
                }
            }
            return sparseArr;

    }

    public static int[][] restore(int[][] sparse) { // 將稀疏矩陣轉回一般矩陣
        int row = sparse[0][0];
        int column = sparse[0][1];
        int[][] array = new int[row][column];

        for (int i = 0, k = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (k <= sparse[0][2] &&
                        i == sparse[k][0] && j == sparse[k][1]) {
                    array[i][j] = sparse[k][2];
                    k++;
                }
            }
        }

        return array;
    }
}
