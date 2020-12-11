
public class BinarySearch {
    /**
     * 二分查找基础模版
     *
     * @param array
     * @param target
     * @return
     */
    public int binarySearch(int[] array, int target) {
        //表示  搜索的范围为 闭区间；
        int left = 0, right = array.length - 1, mid;
        //必须有等于，否则会少搜索一个值；
        //如果没有找到最后停止循环，则left》right 并且 left = right+1;
        //关于边界问题请参考https://cloud.tencent.com/developer/article/1580669
        while (left <= right) {
            //因为是整数  所以结果是 中间或者靠近left的；
            mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
