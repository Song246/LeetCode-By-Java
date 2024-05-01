package daily;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *2462、雇佣K位工人的总代价（优先队列分别维护前半段和后半段最小代价）
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-05-01 10:51
 **/
public class day240501 {
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            long ans = 0L;
            int n = costs.length;
            if(2*candidates+k>n) {  // 全部范围都能取
                Arrays.sort(costs);
                for(int i=0;i<k;i++) ans+=costs[i];
                return ans;
            }

            PriorityQueue<Integer> left = new PriorityQueue<>();
            PriorityQueue<Integer> right = new PriorityQueue<>();
            for(int i=0;i<candidates;i++) {
                left.offer(costs[i]);
                right.offer(costs[n-1-i]);
            }
            int l=candidates,r=n-1-candidates;
            while(k-- > 0) {
                if(left.peek()<=right.peek()) {
                    ans+=left.poll();
                    if(l<n) left.offer(costs[l++]);
                }else {
                    ans+=right.poll();
                    if(r>=0) right.offer(costs[r--]);
                }
            }
            return ans;

        }
    }
}
