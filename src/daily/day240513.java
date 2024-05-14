package daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子(多源bfs)
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-05-14 21:32
 **/
public class day240513 {
    class Solution {
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        public int orangesRotting(int[][] grid) {
            int m=grid.length,n=grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int freshNums = 0;
            int times=0;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j]==1) freshNums++;
                    // 多源bfs，把初始起点都加入队列
                    else if(grid[i][j]==2) {
                        queue.add(new int[]{i,j});
                    }
                }
            }

            while(freshNums>0&&!queue.isEmpty()) {  // freshNums>0 的条件容易忘
                int size = queue.size();
                int[] cur;
                int nextX,nextY;
                for(int i=0;i<size;i++) {
                    cur = queue.poll();

                    for(int j=0;j<4;j++) {
                        nextX=cur[0]+dir[j][0];
                        nextY=cur[1]+dir[j][1];
                        if(nextX<0||nextX>=m||nextY<0||nextY>=n) continue;
                        if(grid[nextX][nextY]==1) {
                            grid[nextX][nextY]=2; // 放在外面由于不是访问但是还没被设为腐烂橘子，会被重复加入
                            queue.add(new int[]{nextX,nextY});
                            freshNums--;
                        }
                    }
                }
                times++;

            }

            return freshNums==0?times:-1;




        }
    }
}
