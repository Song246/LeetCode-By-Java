package daily;

/** 2105. 给植物浇水 II（双向双指针模拟）
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-05-09 12:54
 **/
public class day240509 {

    class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int n = plants.length;
            int waterA = capacityA,waterB=capacityB;
            int l=0,r=n-1;
            int ans = 0;
            while(true) {
                if(l<r) {
                    // A没有足够的水，次数+1，打满水
                    if(waterA<plants[l]) {
                        ans++;
                        waterA=capacityA;
                    }
                    waterA-=plants[l];
                    l++;
                    // B没有足够的水，次数+1，打满水
                    if(waterB<plants[r]) {
                        ans++;
                        waterB=capacityB;
                    }
                    waterB-=plants[r];
                    r--;
                }else if(l==r){
                    // 只剩一个，选大的进行浇水，都不够重新去打水
                    if(waterA<plants[l]&&waterB<plants[l]) {
                        ans++;
                    }
                    break;
                }else {
                    break;
                }
            }
            return ans;
        }
    }
}
