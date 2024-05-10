package daily;

/**
 * 2960. 统计已测试设备(easy，模拟，没必要看)
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-05-10 12:51
 **/
public class day240510 {

    class Solution {
        public int countTestedDevices(int[] batteryPercentages) {
            int ans = 0;
            for(int i=0;i<batteryPercentages.length;i++) {
                if(batteryPercentages[i]>ans) ans++;

            }
            return ans;
        }
    }
}
