package com.scpb.test;

import java.util.Arrays;
import java.util.Scanner;

// 最短路径计算，状压dp
// http://marveliu-md.oss-cn-beijing.aliyuncs.com/md/2019-04-14-150734.png

/**
 * 节点定义
 *
 */
class Point {
    // x坐标点
    int px;
    // y坐标点
    int py;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;

    }

    /**
     * 两个点的距离计算
     *
     * @param p
     * @return
     */
    public int getLength(Point p) {

        return Math.abs(px - p.px) + Math.abs(py - p.py);

    }

}

/**
 * 主的实现类
 *
 */
class Main {

    static final Point START = new Point(0, 0);

    static int minpath = Integer.MAX_VALUE;

    /**
     * 根据自己的实现想法进行实现，可以新添加子函数等
     *
     * @param start  开始节点
     * @param points 节点序列
     * @return
     */
    public static int calculateMinPath(Point start, Point[] points) {
        int n = points.length;
        int[] fac = new int[20];
        fac[0] = 1;
        // 2的阶层，考虑复杂度n^2 * 2^n，20个节点复杂度已经很高了
        for (int i = 0; i < n; i++) {
            fac[i] = fac[i - 1] * 2;
        }
        int[][] dp = new int[1 << 20][20];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // 初始化所有节点到start的距离
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = start.getLength(points[i]);
        }
        // 状压dp，枚举所有的状态2^20
        for (int i = 1; i < fac[n]; i++) {
            for (int j = 0; j < n; j++) {
                // dp[i][j] 表示 i状态下，最后访问的是j节点，并且要保证j节点在i状态中
                if ((i & fac[j]) > 0) {
                    // 枚举之前的状态，进行dp
                    int ls = i ^ fac[j];
                    for (int k = 0; k < n; k++) {
                        if ((ls & fac[k]) > 0) {
                            dp[i][j] = Math.min(dp[i][j], dp[ls][k] + points[j].getLength(points[k]));
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[fac[n] - 1][i] + start.getLength(points[i]));
        }
        return ans;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 输入行数
        int pnum = Integer.parseInt(input.nextLine().trim());
        Point[] points = new Point[pnum];
        for (int i = 0; i < pnum; i++) {
            String[] locations = input.nextLine().trim().split(",");
            // 输入每个点的坐标
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = calculateMinPath(START, points);
        System.out.println(min);
    }
}