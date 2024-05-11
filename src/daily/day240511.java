package daily;

import java.util.HashSet;

/**
 * 2391. 收集垃圾的最少总时间（模拟：分别计算收集垃圾时间和达到最后出现位置的路程时间，lastIdx）
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-05-11 12:29
 **/
public class day240511 {

    class Solution {
        // 计算收集垃圾时间+达到最后出现位置的路程时间
        public int garbageCollection(String[] garbage, int[] travel) {
            int ans = 0;
            int lastM=0,lastP=0,lastG=0;    // 最后出现位置
            String str;
            for(int i=0;i<garbage.length;i++) {
                str=garbage[i];
                ans+=str.length(); // 收集垃圾所需时间
                for(char c:str.toCharArray()) {
                    if(c=='M') lastM=i;
                    if(c=='P') lastP=i;
                    if(c=='G') lastG=i;
                }
            }

            // 计算路程时间：分别道道MGP最后出现位置需的时间
            for(int i=0;i<travel.length;i++) {
                if (lastM > i)
                    ans += travel[i];
                if (lastP > i)
                    ans += travel[i];
                if (lastG > i)
                    ans += travel[i];
            }

            return ans;
        }
    }

    // 贡献法：如果garbage[n−2]+garbage[n−1] 包含 M 和 P，
    // 这意味着有两辆车需要行驶 travel[n−3] 分钟，所以travel[n−3] 对答案的贡献是 travel[n−3]⋅2。
    class Solution2 {
        public int garbageCollection(String[] garbage, int[] travel) {
            int ans = garbage[0].length();
            HashSet<Character> seen = new HashSet<>();
            for (int i = garbage.length - 1; i > 0; i--) {
                char[] g = garbage[i].toCharArray();
                for (char c : g) {
                    seen.add(c);
                }
                ans += g.length + travel[i - 1] * seen.size();
            }
            return ans;
        }
    }
}
