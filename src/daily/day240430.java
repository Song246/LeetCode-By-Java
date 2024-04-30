package daily;

/**
 * 2798. 满足目标工作时长的员工数目(easy，一轮for统计没意义)
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-04-30 13:42
 **/
public class day240430 {
    class Solution {
        public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            int res=0;
            for(int h:hours) {
                if(h>=target) res++;
            }
            return res;
        }
    }
}
