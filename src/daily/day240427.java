package daily;

/**
 * 2639. 查询网格图中每一列的宽度(easy、模拟)
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-04-27 13:34
 **/
public class day240427 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1},{22},{333}};
        int[] columnWidth = solution.findColumnWidth(grid);

    }


}
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for(int j=0;j<grid[0].length;j++) {    // 先列再行
            int maxVal=grid[0][j];
            int minVal=grid[0][j];
            for(int i=0;i<grid.length;i++) {
                if(grid[i][j]>maxVal) {
                    maxVal=grid[i][j];
                }
                if(grid[i][j]<minVal) {
                    minVal=grid[i][j];
                }
            }
            maxVal=String.valueOf(maxVal).length();
            minVal=String.valueOf(minVal).length();
            ans[j]=Math.max(maxVal,minVal);
        }
        return ans;
    }

}
