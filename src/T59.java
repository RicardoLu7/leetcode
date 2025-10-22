import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T59 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //第1行：方法定义，输入课程数量 numCourses 和先修条件数组 prerequisites
        //第3行：创建邻接表 graph，用于存储图的连接关系
        //第4行：创建入度数组 inDegree，记录每个课程的先修课程数量
        List<List<Integer>> graph =  new ArrayList<>();
        int[] inDegree = new int[numCourses];
        // 初始化邻接表
        //为每个课程创建一个空的邻接列表
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //第12行：遍历所有先修条件
        //第13-14行：提取当前先修条件的信息：
        //course：要学习的课程
        //prerequisite：需要先修的课程
        //第15行：在邻接表中添加边：先修课程 → 后续课程
        //第16行：增加后续课程的入度（因为它多了一个先修要求）
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisites = pre[1];
            graph.get(prerequisites).add(course);// 先修课程指向后续课程
            inDegree[course]++;// 后续课程的入度+1
        }

        //第19行：创建队列，用于BFS遍历
        //第20-24行：遍历所有课程，将入度为0的课程加入队列
        //入度为0的课程表示没有先修要求，可以直接学习
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }

        //第26行：初始化计数器，记录成功学习的课程数量
        //第27行：当队列不为空时继续处理
        //第28行：从队列中取出当前课程
        //第29行：计数器加1，表示成功学习了一门课程
        int count = 0;// 记录已学习的课程数量
        while (!queue.isEmpty()){
            int current = queue.poll();
            count++;
        }

        //第32行：遍历当前课程的所有后续课程
        //第33行：减少后续课程的入度（因为它的一个先修课程已经学完了）
        //第34-36行：如果后续课程的入度变为0，说明它的所有先修课程都已完成，可以加入队列准备学习
        // 遍历当前课程的所有后续课程
        for (int next : graph.get(current)) {
            inDegree[next]--;// 后续课程的入度-1
            if (inDegree[next] == 0){
                queue.offer(next);// 如果入度为0，加入队列
            }
        }

        // 如果所有课程都能学习，返回true，否则false
        return count == numCourses;
    }


}
