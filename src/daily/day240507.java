package daily;

/**
 * 1463. 摘樱桃 II（hard，三维dp，难点：dp定义dp[i][j][k]，AB一定在同一行，所以三维dp定义，A在(i,j)B在（i，k）的最大之和）
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-05-07 13:52
 **/
public class day240507 {


    // 自写dp
    class Solution {
        public int cherryPickup(int[][] grid) {
            int m = grid.length,n=grid[0].length;
            int[][][] f = new int[m][n][n];    // A和B肯定在同一行，i表示,[i][j][k] A在（i,j）B在（i，k）的最大val
            int ans=0;
            for(int i=0;i<m;i++) {
                f[i][0][n-1]=grid[i][0]+grid[i][n-1];
                ans=Math.max(ans,f[i][0][n-1]);
            }

            for(int i=1;i<m;i++) {
                for(int j=0;j<Math.min(n-1,i+1);j++) {  // j到不了最后一列，且j每次最多向右一格，小于i+1，取min
                    if(j==0) {
                        for(int k=n-1;k>Math.max(j,n-i-2);k--) {    // J!=K，K大于i且K最多向左到n-i-1的位置
                            if(k==n-1) {
                                f[i][j][k] = max(
                                        f[i-1][j][k-1],f[i-1][j][k],
                                        f[i-1][j+1][k-1],f[i-1][j+1][k]
                                ) + grid[i][j] + grid[i][k];
                            }else {
                                f[i][j][k] = max(
                                        f[i-1][j][k-1],f[i-1][j][k], f[i-1][j][k+1],
                                        f[i-1][j+1][k-1],f[i-1][j+1][k], f[i-1][j+1][k+1]
                                ) + grid[i][j] + grid[i][k];
                            }
                            ans=Math.max(ans,f[i][j][k]);
                        }
                    }else {    // J>1
                        for(int k=n-1;k>Math.max(j,n-i-2);k--) {    // J!=K，K大于i且K最多向左到n-i-1的位置，取max
                            if(k==n-1) {
                                f[i][j][k] = max(
                                        f[i-1][j-1][k-1], f[i-1][j-1][k],
                                        f[i-1][j][k-1],f[i-1][j][k],
                                        f[i-1][j+1][k-1],f[i-1][j+1][k]
                                ) + grid[i][j] + grid[i][k];
                            }else {
                                f[i][j][k] = max(
                                        f[i-1][j-1][k-1], f[i-1][j-1][k], f[i-1][j-1][k+1],
                                        f[i-1][j][k-1],f[i-1][j][k], f[i-1][j][k+1],
                                        f[i-1][j+1][k-1],f[i-1][j+1][k], f[i-1][j+1][k+1]
                                ) + grid[i][j] + grid[i][k];
                            }
                            ans=Math.max(ans,f[i][j][k]);
                        }
                    }

                }
            }
            return ans;
        }

        private int max(int x, int... y) {
            for (int v : y) {
                x = Math.max(x, v);
            }
            return x;
        }
    }


    // 灵神写法
    class Solution2 {
        public int cherryPickup(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][][] f = new int[m + 1][n + 2][n + 2]; // 这里m+1,n+2，多申请一点空间，就不用判断越界问题了
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < Math.min(n, i + 1); j++) {
                    for (int k = Math.max(j + 1, n - 1 - i); k < n; k++) {
                        f[i][j + 1][k + 1] = max(
                                f[i + 1][j][k], f[i + 1][j][k + 1], f[i + 1][j][k + 2],
                                f[i + 1][j + 1][k], f[i + 1][j + 1][k + 1], f[i + 1][j + 1][k + 2],
                                f[i + 1][j + 2][k], f[i + 1][j + 2][k + 1], f[i + 1][j + 2][k + 2]
                        ) + grid[i][j] + grid[i][k];
                    }
                }
            }
            return f[0][1][n];
        }

        private int max(int x, int... y) {
            for (int v : y) {
                x = Math.max(x, v);
            }
            return x;
        }
    }


}


