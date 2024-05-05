package daily;

import java.util.Arrays;

/**
 * 1652、拆炸弹（前缀和、将循环数组扩大两倍变为非循环数组）
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-05-05 14:18
 **/
public class day240505 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int[] ans = new int[n];
            if(k==0) return ans;

            // 前缀和数组 S[i]={s0、s1....s[i-1]}
            int[] sum = new int[2*n+1]; // 扩大两倍，将循环数组变为不是循环的数组
            for(int i=1;i<=2*n;i++) sum[i]+=sum[i-1]+code[(i-1)%n];

            for(int i=1;i<=n;i++) {
                if(k<0) ans[i-1]=sum[i+n-1]-sum[i+n+k-1];
                else ans[i-1]=sum[i+k]-sum[i];
            }
            return ans;
        }
    }


    class Solution2 {
        public int[] decrypt(int[] code, int k) {
            if(k==0) {
                Arrays.fill(code,0);
                return code;
            }
            int[] ans=null;
            ans=code.clone();
            int n = code.length;
            int tmp = 0;
            if(k>0) {
                for(int i=1;i<=k;i++) {
                    tmp+=code[i%n];
                }
                ans[0]=tmp;
                for(int i=1;i<n;i++) {
                    tmp=tmp-code[i]+code[(i+k)%n];
                    ans[i]=tmp;
                }
            }else {
                for(int i=1;i<=-k;i++) {
                    tmp+=code[(n-1-i)%n];
                }
                ans[n-1]=tmp;
                for(int i=n-2;i>=0;i--) {
                    tmp=tmp-code[i%n]+code[(n+k+i)%n];
                    ans[i]=tmp;
                }
            }

            return ans;

        }

    }
}

