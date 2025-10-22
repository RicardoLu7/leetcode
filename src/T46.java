public class T46 {
    public int numTrees(int n) {
        // 卡特兰数公式的优化实现
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2L * i + 1) / (i + 2);

        }
        return (int) C;
    }
}
