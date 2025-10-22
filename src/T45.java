public class T45 {
    class Solution {
        // 主方法：在二维网格中搜索单词
        public boolean exist(char[][] board, String word) {
            // 遍历网格中的每一个单元格作为搜索起点
            //行
            for (int i = 0; i < board.length; i++) {
                //列
                for (int j = 0; j < board[0].length; j++) {
                    // 从当前单元格开始深度优先搜索
                    // 如果找到匹配的单词路径，立即返回true
                    if (dfs(board, word, i, j, 0)) return true;
                }
            }
            // 所有起点都尝试过但没有找到，返回false
            return false;
        }

        /**
         * 深度优先搜索方法
         * @param board 二维字符网格
         * @param word 要搜索的单词
         * @param i 当前行坐标
         * @param j 当前列坐标
         * @param index 当前要匹配的字符在word中的位置
         * @return 是否找到匹配的路径
         */
        private boolean dfs(char[][] board, String word, int i, int j, int index) {
            // 终止条件1：已经匹配完单词的所有字符
            // index从0开始，当index等于单词长度时，说明所有字符都已成功匹配
            if (index == word.length()) return true;

            // 终止条件2：当前位置无效或字符不匹配
            // - 行坐标越界：i < 0 或 i >= board.length
            // - 列坐标越界：j < 0 或 j >= board[0].length
            // - 字符不匹配：board[i][j] != word.charAt(index)
            // 注意：这里也包含了检查是否已访问，因为已访问的单元格被标记为'#'
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                    board[i][j] != word.charAt(index)) return false;

            // 保存当前单元格的原始字符，用于后续回溯恢复
            char temp = board[i][j];

            // 标记当前单元格为已访问
            // 使用特殊字符'#'标记，这样在后续递归中如果再次访问到这里就会因为字符不匹配而返回false
            board[i][j] = '#';

            // 向四个方向进行深度优先搜索
            // 使用短路或(||)，只要有一个方向找到解就立即返回，不再继续搜索其他方向
            boolean found = dfs(board, word, i + 1, j, index + 1) ||  // 向下搜索
                    dfs(board, word, i - 1, j, index + 1) ||  // 向上搜索
                    dfs(board, word, i, j + 1, index + 1) ||  // 向右搜索
                    dfs(board, word, i, j - 1, index + 1);    // 向左搜索

            // 回溯：恢复当前单元格的原始字符
            // 释放状态：无论探索结果如何，都要"释放"这个单元格
            // 这样其他搜索路径可以重新使用这个单元格
            board[i][j] = temp;

            // 返回搜索结果
            // 如果四个方向中任何一个找到了完整路径，found就是true，否则为false
            return found;
        }
    }
}
