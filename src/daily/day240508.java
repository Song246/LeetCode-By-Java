package daily;

/**
 * 2079. 给植物浇水（模拟）
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-05-08 12:43
 **/
public class day240508 {

    // 自写模拟
    class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            boolean[] visited = new boolean[plants.length];
            int ans = 0;
            int left = capacity;
            int start=-1;   // 记录上一次起始位置
            for(int i=0;i<plants.length;i++) {
                ans+=(i-start);
                start=i;
                left-=plants[i];

                if(i<plants.length-1&&left<plants[i+1]) {
                    ans+=i+1;
                    start=-1;   // 不够下一次浇水，回到起始位置
                    left=capacity;
                }
            }
            return ans;
        }
    }

    // 精简
    class Solution2 {
        public int wateringPlants(int[] plants, int capacity) {
            boolean[] visited = new boolean[plants.length];
            int ans = 0;
            int left = capacity;
            for(int i=0;i<plants.length;i++) {
                if(left>=plants[i]) {
                    ans++;
                    left-=plants[i];
                }else {
                    ans+=2*i+1; // 当前不够了，回到起点再过来
                    left=capacity-plants[i];
                }
            }
            return ans;
        }
    }
}
