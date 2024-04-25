package daily;

/**
 * 2739. 总行驶距离(easy，模拟)
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-04-25 12:27
 **/
public class day240425 {

    public static void main(String[] args) {

    }

    class Solution {
        public int distanceTraveled(int mainTank, int additionalTank) {
            int round=0;
            int ans=0;
            while(mainTank>0){
                mainTank--;
                ans+=10;
                round++;
                if(round%5==0&&additionalTank>0){
                    mainTank++;
                    additionalTank--;
                }

            }
            return ans;
        }
    }
}
