public class T35 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //对角线翻转（转置）
        //j = i + 1：只处理对角线右上方的元素，避免重复交换
        //交换 matrix[i][j] 和 matrix[j][i]：实现转置
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 水平翻转
        //j < n / 2：只需要交换前半列和对应的后半列
        //n - 1 - j：找到对称位置的列索引
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
