/**
 * 这个精简了好多，但也有问题明天来
 */


public class Test4_2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //首先去找中位数的位置
        int middle = (nums1.length + nums2.length) >> 1;   //奇数的话，中就是middle+1   偶数的话，就是middle和middle+1
        boolean Odd = ((nums1.length + nums2.length) % 2 == 1) ? true : false;
        float sum = 0;
        int num1f = 0,num2f = 0;
        for (int i = 0;i <= middle + 1;i++) {
	    if (num2f >= nums2.length||(num1f < nums1.length&&nums1[num1f] < nums2[num2f])) {
		num1f++;
		if ((!Odd && i == middle)||i == middle + 1)
	 	    sum += nums1[num1f];
	    } else {
	        num2f++;
		if ((!Odd && i == middle)||i == middle + 1)
		    sum += nums2[num2f];
	    }
	}
	return Odd ? sum : sum/2;
    }


    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.print(findMedianSortedArrays(a, b));
    }
}
