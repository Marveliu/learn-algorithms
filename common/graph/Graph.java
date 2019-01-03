import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

// 参考: https://www.cnblogs.com/skywang12345/p/3711532.html
// 图算法实现:
// bfs,dfs
// prim kruskal
// dijkstar floyd

public class Graph {

    private int mEdgNum; // 边的数量
    private char[] mVexs; // 顶点集合
    private int[][] mMatrix; // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE; // 最大值

    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明： vexs -- 顶点数组 matrix-- 矩阵(数据)
     */
    public Graph(char[] vexs, int[][] matrix) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                mMatrix[i][j] = matrix[i][j];

        // 统计"边"
        mEdgNum = 0;
        for (int i = 0; i < vlen; i++)
            for (int j = i + 1; j < vlen; j++)
                if (mMatrix[i][j] != INF)
                    mEdgNum++;
    }

    /*
     * 返回顶点v的第一个邻接顶点的索引，失败则返回-1
     */
    private int firstVertex(int v) {

        if (v < 0 || v > (mVexs.length - 1)) {
            return -1;
        }

        for (int i = 0; i < mVexs.length; i++) {
            if (mMatrix[v][i] != 0 && mMatrix[v][i] != INF) {
                return i;
            }
        }

        return -1;
    }

    /*
     * 返回顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
     */
    private int nextVertex(int v, int w) {
        if (v < 0 || v > (mVexs.length - 1) || w < 0 || w > (mVexs.length - 1))
            return -1;

        for (int i = w + 1; i < mVexs.length; i++)
            if (mMatrix[v][i] != 0 && mMatrix[v][i] != INF)
                return i;

        return -1;
    }

    /*
     * 深度优先搜索遍历图的递归实现
     */
    private void DFS(int i, boolean[] visited) {
        for (int k = firstVertex(i); k >= 0; k = nextVertex(i, k)) {
            if (!visited[k]) {
                System.out.printf("%c", mVexs[k]);
                visited[k] = true;
                DFS(k, visited);
            }
        }
    }

    /*
     * 深度优先搜索遍历图
     */
    public void DFS() {
        System.out.println("DFS:");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visit = new boolean[mVexs.length];
        deque.add(0);
        while (!deque.isEmpty()) {
            int current = deque.pollFirst();
            if (!visit[current]) {
                System.out.printf("%c", mVexs[current]);
                visit[current] = true;
            }
            for (int k = firstVertex(current); k >= 0; k = nextVertex(current, k)) {
                if (!visit[k]) {
                    deque.addFirst(k);
                }
            }
        }
        System.out.println();
    }

    /*
     * 广度优先搜索（类似于树的层次遍历）
     */
    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];
        boolean[] visit = new boolean[mVexs.length];
        for (int i = 0; i < mVexs.length; i++) {
            visit[i] = false;
        }

        System.out.println("BFS:");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                System.out.printf("%c", mVexs[i]);
                queue[rear++] = i;
            }

            while (head != rear) {
                // 出队列
                int j = queue[head++];
                for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) {
                    if (!visit[k]) {
                        visit[k] = true;
                        System.out.printf("%c", mVexs[k]);
                        queue[rear++] = k;
                    }
                }
            }
        }
        System.out.println();
    }

    /*
     * 打印矩阵队列图
     */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++) {
                if (mMatrix[i][j] == INF) {
                    System.out.printf("%10s", "#");
                } else {
                    System.out.printf("%10d", mMatrix[i][j]);
                }
            }
            System.out.printf("\n");
        }
    }

    /*
     * prim最小生成树
     */
    public void prim(int start) {
        System.out.println("PRIM:");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int[] vd = new int[mVexs.length];
        int[] vp = new int[mVexs.length];
        boolean[] visit = new boolean[mVexs.length];

        Arrays.fill(vd, 1, vd.length, INF);
        Arrays.fill(vp, 1, vp.length, -1);
        while (!queue.isEmpty()) {
            Integer u = queue.pollFirst();
            if (!visit[u]) {
                visit[u] = true;
                System.out.printf("%s", mVexs[u]);
                for (int k = firstVertex(u); k >= 0; k = nextVertex(u, k)) {
                    if (!visit[k]) {
                        int value = mMatrix[u][k];
                        if (value <= vd[k]) {
                            vd[k] = value;
                            vp[k] = u;
                        }
                    }
                }
                int min = INF;
                int select = -1;
                for (int i = 0; i < vd.length; i++) {
                    if (!visit[i] && vd[i] <= min) {
                        select = i;
                        min = vd[i];
                    }
                }
                if (select != -1)
                    queue.add(select);
            }
        }
        System.out.println();
        System.out.println("vd:" + Arrays.toString(vd));
        System.out.println("vp:" + Arrays.toString(vp));
    }

    /*
     * 克鲁斯卡尔（Kruskal)最小生成树
     */
    public void kruskal() {
        System.out.println("KRUSKAL:");
        EData[] edges = getEdges();
        sortEdges(edges);
        ArrayList<Character> visit = new ArrayList<>();
        for (EData var : edges) {
            System.out.println(Arrays.toString(visit.toArray()));
            if (visit.size() == mVexs.length) {
                break;
            }
            if (visit.contains(var.start) && visit.contains(var.end)) {
                continue;
            }
            if (!visit.contains(var.start))
                visit.add(var.start);
            if (!visit.contains(var.end))
                visit.add(var.end);
        }
    }

    /*
     * 获取图中的边
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] eDatas = new EData[mEdgNum];
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = i + 1; j < mVexs.length; j++) {
                if (mMatrix[i][j] != INF) {
                    eDatas[index++] = new EData(mVexs[i], mVexs[j], mMatrix[i][j]);
                }
            }
        }
        return eDatas;
    }

    /*
     * 对边按照权值大小进行排序(由小到大)
     */
    private void sortEdges(EData[] edges) {
        Arrays.sort(edges, new Comparator<EData>() {
            @Override
            public int compare(EData o1, EData o2) {
                return o1.weight - o2.weight;
            }
        });
    }

    /*
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *
     * 参数说明： vs -- 起始顶点(start vertex)
     * 即计算"顶点vs"到其它顶点的最短路径。 prev --
     * 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *  dist
     * --
     * 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     * 
     * 
     */
    public void dijkstra(int vs) {
        System.out.println("DIJKSTRA:");
        boolean[] visit = new boolean[mVexs.length];
        int[] vd = new int[mVexs.length];
        int[] vp = new int[mVexs.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.fill(vd, INF);
        Arrays.fill(vp, -1);
        vd[vs] = 0;
        vp[vs] = vs;
        queue.add(vs);
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            System.out.printf("%s", mVexs[u]);
            if (!visit[u]) {
                visit[u] = true;
                for (int i = firstVertex(u); i >= 0; i = nextVertex(u, i)) {
                    if (!visit[i]) {
                        int value = vd[u] + mMatrix[u][i];
                        if (value <= vd[i]) {
                            vd[i] = value;
                            vp[i] = u;
                        }
                    }
                }
                int min = INF;
                int select = -1;
                for (int i = 0; i < vd.length; i++) {
                    if (!visit[i] && vd[i] <= min) {
                        min = vd[i];
                        select = i;
                    }
                }
                if (select != -1)
                    queue.add(select);
            }
        }
        System.out.println();
        System.out.println("vd:" + Arrays.toString(vd));
        System.out.println("vp:" + Arrays.toString(vp));
    }

    /**
     * floyd算法 动态规划
     * 
     * @param vs
     */
    public void floyd() {

        System.out.println("FLOYD:");

        // D代表顶点与顶点的最短路径权值和的矩阵
        int[][] dist = new int[mVexs.length][mVexs.length];
        // P代表对应顶点的最短路径的前驱矩阵
        int[][] path = new int[mVexs.length][mVexs.length];


        // 初始化
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++) {
                dist[i][j] = mMatrix[i][j];    // "顶点i"到"顶点j"的路径长度为"i到j的权值"。
                path[i][j] = j;                // "顶点i"到"顶点j"的最短路径是经过顶点j。
            }
        }

        System.out.println();
        for (int[] var : dist) {
            System.out.println(Arrays.toString(var));
        }
        System.out.println();
        for (int[] var : path) {
            System.out.println(Arrays.toString(var));
        }

        // 计算最短路径
        // Floyd算法的本质是DP，而k是DP的阶段，因此要写最外面
        // 逐渐计算包含1...K个节点的最短路径
        for (int k = 0; k < mVexs.length; k++) {
            for (int i = 0; i < mVexs.length; i++) {
                for (int j = 0; j < mVexs.length; j++) {
                    // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                    int tmp = (dist[i][k]==INF || dist[k][j]==INF) ? INF : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp) {
                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                        dist[i][j] = tmp;
                        // "i到j最短路径"对应的路径，经过k
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
        // 打印floyd最短路径的结果
        System.out.printf("floyd: \n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%2d  ", dist[i][j]);
            System.out.printf("\n");
        }

        System.out.println();
        for (int[] var : dist) {
            System.out.println(Arrays.toString(var));
        }
        System.out.println();
        for (int[] var : path) {
            System.out.println(Arrays.toString(var));
        }
        
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = i + 1; j < mVexs.length; j++) {
                System.out.printf("v%d-v%d  weight:%d  path:%s", i, j, dist[i][j],mVexs[i]);
                // 输出最短路径
                int k = path[i][j];
                while (k != j) {
                    System.out.printf("->%s", mVexs[k]);
                    k = path[k][j];
                }
                System.out.printf("->%s", mVexs[j]);
                System.out.println();
            }
        }
    }

    // 边的结构体
    private static class EData {
        char start; // 边的起点
        char end; // 边的终点
        int weight; // 边的权重

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    };

    public static void main(String[] args) {
        char[] vexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int matrix[][] = {
                /* A *//* B *//* C *//* D *//* E *//* F *//* G */
                /* A */ { 0, 12, INF, INF, INF, 16, 14 }, 
                /* B */ { 12, 0, 10, INF, INF, 7, INF },
                /* C */ { INF, 10, 0, 3, 5, 6, INF }, 
                /* D */ { INF, INF, 3, 0, 4, INF, INF },
                /* E */ { INF, INF, 5, 4, 0, 2, 8 }, 
                /* F */ { 16, 7, 6, INF, 2, 0, 9 },
                /* G */ { 14, INF, INF, INF, 8, 9, 0 } };
        Graph pG;
        // 采用已有的"图"
        pG = new Graph(vexs, matrix);
        pG.print(); // 打印图
        System.out.println("DFS:");
        pG.DFS(0, new boolean[vexs.length]);
        System.out.println();
        pG.DFS(); // 深度优先遍历
        pG.BFS(); // 广度优先遍历
        pG.prim(0); // prim算法生成最小生成树
        pG.kruskal(); // Kruskal算法生成最小生成树
        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
        pG.dijkstra(3);
        // floyd算法获取所有点对的距离
        pG.floyd();
    }
}

// Martix Graph:
//          0        12         #         #         #        16        14
//         12         0        10         #         #         7         #
//          #        10         0         3         5         6         #
//          #         #         3         0         4         #         #
//          #         #         5         4         0         2         8
//         16         7         6         #         2         0         9
//         14         #         #         #         8         9         0
// DFS:
// BAFCDEG
// DFS:
// AGFEDCB
// BFS:
// ABFGCED
// PRIM:
// ABFEDCG
// vd:[0, 12, 3, 4, 2, 7, 8]
// vp:[0, 0, 3, 4, 5, 1, 4]
// KRUSKAL:
// []
// [E, F]
// [E, F, C, D]
// [E, F, C, D]
// [E, F, C, D]
// [E, F, C, D]
// [E, F, C, D, B]
// [E, F, C, D, B, G]
// [E, F, C, D, B, G]
// [E, F, C, D, B, G]
// [E, F, C, D, B, G, A]
// DIJKSTRA:
// DCEFGBA
// vd:[22, 13, 3, 0, 4, 6, 12]
// vp:[5, 5, 3, 3, 3, 4, 4]
// FLOYD:

// [0, 12, 2147483647, 2147483647, 2147483647, 16, 14]
// [12, 0, 10, 2147483647, 2147483647, 7, 2147483647]
// [2147483647, 10, 0, 3, 5, 6, 2147483647]
// [2147483647, 2147483647, 3, 0, 4, 2147483647, 2147483647]
// [2147483647, 2147483647, 5, 4, 0, 2, 8]
// [16, 7, 6, 2147483647, 2, 0, 9]
// [14, 2147483647, 2147483647, 2147483647, 8, 9, 0]

// [0, 1, 2, 3, 4, 5, 6]
// [0, 1, 2, 3, 4, 5, 6]
// [0, 1, 2, 3, 4, 5, 6]
// [0, 1, 2, 3, 4, 5, 6]
// [0, 1, 2, 3, 4, 5, 6]
// [0, 1, 2, 3, 4, 5, 6]
// [0, 1, 2, 3, 4, 5, 6]
// floyd:
//  0  12  22  22  18  16  14
// 12   0  10  13   9   7  16
// 22  10   0   3   5   6  13
// 22  13   3   0   4   6  12
// 18   9   5   4   0   2   8
// 16   7   6   6   2   0   9
// 14  16  13  12   8   9   0

// [0, 12, 22, 22, 18, 16, 14]
// [12, 0, 10, 13, 9, 7, 16]
// [22, 10, 0, 3, 5, 6, 13]
// [22, 13, 3, 0, 4, 6, 12]
// [18, 9, 5, 4, 0, 2, 8]
// [16, 7, 6, 6, 2, 0, 9]
// [14, 16, 13, 12, 8, 9, 0]

// [0, 1, 1, 5, 5, 5, 6]
// [0, 1, 2, 2, 5, 5, 5]
// [1, 1, 2, 3, 4, 5, 4]
// [4, 2, 2, 3, 4, 4, 4]
// [5, 5, 2, 3, 4, 5, 6]
// [0, 1, 2, 4, 4, 5, 6]
// [0, 5, 4, 4, 4, 5, 6]
// v0-v1  weight:12  path:A->B
// v0-v2  weight:22  path:A->B->C
// v0-v3  weight:22  path:A->F->E->D
// v0-v4  weight:18  path:A->F->E
// v0-v5  weight:16  path:A->F
// v0-v6  weight:14  path:A->G
// v1-v2  weight:10  path:B->C
// v1-v3  weight:13  path:B->C->D
// v1-v4  weight:9  path:B->F->E
// v1-v5  weight:7  path:B->F
// v1-v6  weight:16  path:B->F->G
// v2-v3  weight:3  path:C->D
// v2-v4  weight:5  path:C->E
// v2-v5  weight:6  path:C->F
// v2-v6  weight:13  path:C->E->G
// v3-v4  weight:4  path:D->E
// v3-v5  weight:6  path:D->E->F
// v3-v6  weight:12  path:D->E->G
// v4-v5  weight:2  path:E->F
// v4-v6  weight:8  path:E->G
// v5-v6  weight:9  path:F->G