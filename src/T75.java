import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T75 {


    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            // 对人群进行排序：首先按身高降序，身高相同的按k值升序
            Arrays.sort(people, (a, b) -> {
                if (a[0] != b[0]) {
                    // 身高不同：按身高降序排列（高的在前）
                    return b[0] - a[0];
                } else {
                    // 身高相同：按k值升序排列（k值小的在前）
                    // 这样保证相同身高的人中，要求前面人少的人先被处理
                    return a[1] - b[1];
                }
            });

            // 使用链表来存储结果，便于插入操作
            List<int[]> result = new ArrayList<>();

            // 遍历排序后的人群，按照每个人的k值作为索引插入到结果列表中
            for (int[] person : people) {
                // person[1] 就是k值，表示这个人前面应该有k个身高 >= 他的人
                // 由于我们已经按身高降序排列，所以当前插入的人比结果列表中已有的人都矮（或相等）
                // 因此插入到位置k时，前面正好有k个身高 >= 他的人
                result.add(person[1], person);

                // 插入过程解析：
                // - 高个子先被处理，因为他们不受后面矮个子的影响
                // - 当插入一个身高为h，k值为k的人时：
                //   前面已经有k个身高 >= h的人（因为高个子先插入）
                //   后面插入的矮个子不会影响这个计数（因为矮个子排在后面）
            }

            // 将链表转换为二维数组返回
            return result.toArray(new int[people.length][]);
        }
    }
}
