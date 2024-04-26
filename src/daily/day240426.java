package daily;

import java.util.*;

/**
 * 1146. 快照数组(设计类，类似MVCC快照读；寻找二分首次、末次出现的位置)
 * MVCC的快照读应该也是这样的思路吧，用undolog版本链实现快照读，原来如此，undolog的设计目的理解了
 * @program: LeetCode
 * @description:
 * @author: lydms
 * @create: 2024-04-26 12:36
 **/
public class day240426 {

    public static void main(String[] args) {

    }
    // 方法一：二分查找相同元素最后出现的位置
    class SnapshotArray {
        // 快照编号
        private int curSnapId=0;
        // 每个 index 的历史修改记录,  key: index  val: int[0]当前快照id，int[1] 当前快照版本的值
        private final Map<Integer, List<int[]>> history = new HashMap<>();
        public SnapshotArray(int length) {

        }

        public void set(int index, int val) {
            history.computeIfAbsent(index, k -> new ArrayList<>())
                    .add(new int[]{curSnapId, val});
        }

        public int snap() {
            return curSnapId++;
        }

        public int get(int index, int snap_id) {
            if(!history.containsKey(index)) {
                return 0;   // 不存在
            }
            // 获取index的历史快照数组id和val
            List<int[]> h = history.get(index);
            int j = search(h,snap_id);  // 找到相同快照号的index元素最后出现的位置
            return j<0?0:h.get(j)[1];
        }

        // 找对应快照号下标，x 快照号
        // 快照号可能相同，返回最后出现的位置
        private int search(List<int[]> h, int x) {
            int l=0,r=h.size()-1;
            int mid;
            while(l<=r) {
                mid = (l+r)/2;
                if(x>=h.get(mid)[0]) {
                    l=mid+1;
                } else {
                    r=mid-1;
                }
            }
            // 寻找首次出现返回l，寻找最后出现返回r
            return r;
        }
    }


    // 方法二：寻找相同元素x最后出现的位置，转化为寻找x+1首次出现的位置下标-1
    class SnapshotArray2 {
        // 快照编号
        private int curSnapId=0;
        // 每个 index 的历史修改记录,  key: index  val: int[0]当前快照id，int[1] 当前快照版本的值
        private final Map<Integer, List<int[]>> history = new HashMap<>();
        public SnapshotArray2(int length) {

        }

        public void set(int index, int val) {
            history.computeIfAbsent(index, k -> new ArrayList<>())
                    .add(new int[]{curSnapId, val});
            // if(val==13) {
            //     System.out.println(history.get(index)[0]+"   "+history.get(index)[1]);
            // }
        }

        public int snap() {
            return curSnapId++;
        }

        public int get(int index, int snap_id) {
            if(!history.containsKey(index)) {
                return 0;   // 不存在
            }
            // 获取index的历史快照数组id和val
            List<int[]> h = history.get(index);
            int j = search(h,snap_id+1)-1;  // 存在多个相同快照号，找到相同快照号的最后一个元素，即snapId+1首次出现的位置下标-1
            return j<0?0:h.get(j)[1];
        }

        // 存在多个相同快照号，找到相同快照号的最后一个元素，即snapId+1首次出现的位置下标-1
        // 找对应快照号下标，x 快照号
        private int search(List<int[]> h, int x) {
            int l=0,r=h.size()-1;
            int mid;
            while(l<=r) {
                mid = (l+r)/2;
                if(x<=h.get(mid)[0]) {
                    r=mid-1;
                } else {
                    l=mid+1;
                }
            }
            return l;
        }
    }







    // 超内存版本：
    // 每次调用 snap()，就复制一份数组，可以吗？
    //不行，最坏情况下，复制 50000 次长为 50000 的数组，会「超出内存限制」。
    class SnapshotArray1 {
        ArrayList<Integer> list;
        ArrayList<ArrayList<Integer>> snapArray;
        int snapCnt;
        public SnapshotArray1(int length) {
            snapCnt=0;
            list = new ArrayList<Integer>(Collections.nCopies(length, 0));
            snapArray=new ArrayList<ArrayList<Integer>>();
        }

        public void set(int index, int val) {
            list.set(index,val);
        }

        public int snap() {
            snapArray.add(new ArrayList(list));
            return snapCnt++;
        }

        public int get(int index, int snap_id) {
            return snapArray.get(snap_id).get(index);
        }
    }

    /**
     * Your SnapshotArray object will be instantiated and called as such:
     * SnapshotArray obj = new SnapshotArray(length);
     * obj.set(index,val);
     * int param_2 = obj.snap();
     * int param_3 = obj.get(index,snap_id);
     */
    }
