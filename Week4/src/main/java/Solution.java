public class Solution {
    /**
     * leetcode 69. x 的平方根
     * 方法一：二分查找
     * x 是非负整数，例如：0、1、2、3
     * 返回整数部分 也就是result 肯定是 最大的mid*mid《=x的值
     * 二分查找方法：因为x的平凡根，比x小；所以查找0到x之间的整数；
     * 满足二叉分查找的特性1。0到x递增 2。有左右界限 3。可以索引取值
     * 复杂度O()：时间复杂度是O(logx) 每次减少一般也就是处以2
     * 空间复杂度是O(1);
     *
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        int left = 0;
        int right = x;
        int result = -1;
        //注意是小于等于 ， 循环里面没有return  break 等  是因为最后肯定是left 》right  所以
        //会停止循环
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            //注意long是为了怕mid*mid 大于int的最大值 2^31-1
            if ((long) mid * mid <= x) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;

    }

    /**
     * 牛顿迭代
     * 复杂度O()：时间复杂度是O(logx)， 应该比二分查找更快
     * 空间复杂度是O(1)；
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    /**
     * 牛顿迭代
     * 复杂度O()：时间复杂度是O(logx)， 应该比二分查找更快
     * 空间复杂度是O(1)；
     *
     * @param a
     * @return
     */
    public int mySqrt3(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.mySqrt3(8);
        System.out.println(res);
    }
}
