public class T65 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        // 从右上角开始搜索
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0){
            if (matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] > target){
                // 当前元素太大，向左移动（到更小的列）
                col--;
            }else {
                // 当前元素太小，向下移动（到更大的行）
                row++;
            }
        }
        return false;
    }
}
