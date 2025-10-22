public class T60 {
    /**
     * Trie（前缀树）实现类
     * 用于高效存储和检索字符串数据集
     */
    class Trie {

        // Trie树的根节点，不存储任何字符，作为所有单词的起始点
        private TrieNode root;

        /**
         * Trie节点内部类
         * 每个节点代表一个字符，包含子节点数组和结束标志
         */
        private class TrieNode {
            // 子节点数组，长度为26，对应26个小写英文字母
            // children[0] 对应 'a'，children[1] 对应 'b'，...，children[25] 对应 'z'
            private TrieNode[] children;

            // 标记当前节点是否是一个完整单词的结尾
            // 例如：插入"app"后，第二个'p'节点的isEnd为true
            private boolean isEnd;

            /**
             * TrieNode构造函数
             * 初始化子节点数组和结束标志
             */
            public TrieNode() {
                // 创建26个位置的TrieNode数组，初始值都为null
                children = new TrieNode[26];
                // 新节点默认不是单词结尾
                isEnd = false;
            }
        }

        /**
         * Trie构造函数
         * 初始化前缀树，创建根节点
         */
        public Trie() {
            // 创建根节点，根节点不存储任何字符信息
            root = new TrieNode();
        }

        /**
         * 向Trie树中插入一个单词
         * @param word 要插入的单词字符串
         */
        public void insert(String word) {
            // 从根节点开始遍历
            TrieNode node = root;

            // 遍历单词中的每个字符
            for (char c : word.toCharArray()) {
                // 计算当前字符在children数组中的索引位置
                // 'a' - 'a' = 0, 'b' - 'a' = 1, ..., 'z' - 'a' = 25
                int index = c - 'a';

                // 如果当前字符对应的子节点不存在，创建新的节点
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                // 移动到下一个节点，继续处理下一个字符
                node = node.children[index];
            }

            // 遍历完所有字符后，标记最后一个节点为单词结尾
            node.isEnd = true;
        }

        /**
         * 在Trie树中搜索完整的单词
         * @param word 要搜索的单词字符串
         * @return 如果单词存在且是一个完整单词（不只是前缀），返回true；否则返回false
         */
        public boolean search(String word) {
            // 搜索单词对应的最后一个节点
            TrieNode node = searchPrefix(word);

            // 返回true的条件：
            // 1. 节点存在（找到了所有字符）
            // 2. 该节点标记为单词结尾（是一个完整单词）
            return node != null && node.isEnd;
        }

        /**
         * 检查Trie树中是否有以指定前缀开头的单词
         * @param prefix 要检查的前缀字符串
         * @return 如果存在以该前缀开头的单词，返回true；否则返回false
         */
        public boolean startsWith(String prefix) {
            // 搜索前缀对应的最后一个节点
            TrieNode node = searchPrefix(prefix);

            // 只要节点存在（找到了前缀的所有字符），就返回true
            // 不需要检查isEnd，因为可能是更长单词的前缀
            return node != null;
        }

        /**
         * 私有辅助方法：搜索指定前缀对应的最后一个节点
         * @param prefix 要搜索的前缀字符串
         * @return 如果前缀存在，返回最后一个节点；否则返回null
         */
        private TrieNode searchPrefix(String prefix) {
            // 从根节点开始遍历
            TrieNode node = root;

            // 遍历前缀中的每个字符
            for (char c : prefix.toCharArray()) {
                // 计算当前字符在children数组中的索引位置
                int index = c - 'a';

                // 如果当前字符对应的子节点不存在，说明前缀不存在
                if (node.children[index] == null) {
                    return null;
                }

                // 移动到下一个节点，继续处理下一个字符
                node = node.children[index];
            }

            // 返回前缀的最后一个节点
            return node;
        }
    }
}
