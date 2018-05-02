/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]

 * 中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]

 * 中位数是 (2 + 3)/2 = 2.5
 */


/**
 * 一个简单的思路
 * 没有实现   还有BUG
 */

public class Test4_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //首先去找中位数的位置
        int middle = (nums1.length + nums2.length) >> 1;   //奇数的话，中就是middle+1   偶数的话，就是middle和middle+1
        boolean Odd = ((nums1.length + nums2.length) % 2 == 1) ? true : false;
        int sumflag = 0;
        float sum = 0;
        a:
            for (int i = 0; i < nums1.length; i++) {
            b:
                for (int j = 0; j <nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    if (!Odd && sumflag == middle) {
                        sum += nums1[i];
                    } else if (sumflag == middle + 1){
                        sum += nums1[i];
                        sum /= 2;
                        break;
                    }
                    sumflag++;
                    continue a;
                    } else {
                        if (!Odd && sumflag == middle) {
                            sum += nums2[i];
                        } else if (sumflag == middle + 1){
                            sum += nums2[i];
                            sum /= 2;
                            break;
                        }
                        sumflag++;
                    }
                }
            }
        return sum;
    }
}
