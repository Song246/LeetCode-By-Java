package daily;

import java.util.HashMap;

/**
 * 2244. 完成所有任务需要的最少轮数(数学推理、)
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-05-15 21:06
 **/
public class day240514 {

    class Solution {
        public int minimumRounds(int[] tasks) {
            // 数学公式：
            // 出现次数与需要取的最少次数 （三个一组）
            // 出现次数         1   2   3   4   5   6   7   8   9   10  11  12
            // 取得最少次数     -1  1   1   2   2   2   3   3   3   4   4   4
            int n = tasks.length;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++) {
                if(map.get(tasks[i])==null) {
                    map.put(tasks[i],1);
                }else{
                    map.put(tasks[i],map.get(tasks[i])+1);
                }
            }
            int ans = 0;
            for(int levelNums:map.values()) {
                if(levelNums==1) return -1;
                else {
                    // if(levelNums%3==0) {
                    //     ans+=(levelNums/3);
                    // }else {
                    //     ans+=(levelNums/3)+1;
                    // }
                    ans+=(levelNums+2)/3;   // 直接把上面的if-else替换
                }
            }
            return ans;
        }
    }
}
