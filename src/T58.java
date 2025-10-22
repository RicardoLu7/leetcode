public class T58 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        //获取网格的行数 m
        //获取网格的列数 n（取第一行的长度）
        int m = grid.length;
        int n = grid[0].length;

        //第9-10行：双重循环遍历网格的每一个单元格
        //第11行：如果当前单元格是陆地（'1'）
        //第12行：发现新岛屿，计数器加1
        //第13行：调用DFS方法，将这个岛屿的所有相连陆地标记为已访问
        //第16行：返回最终的岛屿数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        // 边界检查 + 是否为陆地检查
        //i < 0 || i >= m：行坐标越界
        //j < 0 || j >= n：列坐标越界
        //grid[i][j] == '0'：当前是水域或已访问的陆地
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0'){
            return;
        }
        // 将当前陆地标记为已访问（沉没岛屿）
        grid[i][j] = '0';

        // 向四个方向递归搜索
        dfs(grid,i-1,j);  // 上
        dfs(grid,i+1,j);  // 下
        dfs(grid,i,j-1);  // 左
        dfs(grid,i,j+1);  // 右
    }

}
