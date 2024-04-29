package daily;

/**
 * 1329、将矩阵按对角线排序（关键对角线元素的个数：min(m-x,n-y)）
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-04-29 14:06
 **/
public class day240429 {

    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int m=mat.length,n=mat[0].length;
            for(int i=m-2;i>0;i--) sort(mat,i,0);// 第一列，不含（0，0）
            for(int j=0;j<n-1;j++) sort(mat,0,j);   // 第一行
            return mat;
        }

        private void sort(int[][] mat,int x,int y) {
            // 冒泡排序 (x,y)-> (x+a,y+a)
            int m=mat.length,n=mat[0].length;
            // 关键：对角线元素个数n
            int len=Math.min(m-x,n-y);
            for(int i=0;i<len;i++) {
                for(int j=0;j<len-i-1;j++) {
                    if(mat[x+j][y+j]>mat[x+j+1][y+j+1]) {
                        swap(mat,x+j,y+j);
                    }
                }
            }
        }

        private void swap(int[][] mat,int i,int j) {
            int temp = mat[i][j];
            mat[i][j]=mat[i+1][j+1];
            mat[i+1][j+1]=temp;
        }


    }
}

