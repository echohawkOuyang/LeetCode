import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数列，找出其中和为特定值的那两个数。
 * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */

/**
 * 这个超时   19/20
 */
public class Test1_1 {
    public static int[] towSum(int[] num, int target) {
        int[] array = new int[2];
        Map<Integer,Integer> smallThanIndex = new HashMap<>();
        Map<Integer,Integer> bigThanIndex = new HashMap<>();
        Map<Integer,Integer> lowZeroIndex = new HashMap<>();
        Map<Integer,Integer> overZeroIndex = new HashMap<>();
        for (int i = 0; i < num.length; i ++) {
            if (target >= num[i]) {
                smallThanIndex.put(i, num[i]);
            } else {
                bigThanIndex.put(i, num[i]);
            }
            if (num[i] < 0) {
                lowZeroIndex.put(i, num[i]);
            } else {
                overZeroIndex.put(i, num[i]);
            }
        }
        //这里之前是使用的Integer   当Integer超过127之后i！=j 就会判断错误
        for (int i :
             smallThanIndex.keySet()) {
            for (int j :
                 overZeroIndex.keySet()) {
                if ((smallThanIndex.get(i) + overZeroIndex.get(j) == target) && (i != j)) {
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }
        for (int i :
                bigThanIndex.keySet()) {
            for (int j :
                    lowZeroIndex.keySet()) {
                if ((bigThanIndex.get(i) + lowZeroIndex.get(j) == target) && (i != j)) {
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }
        array[0] = 1;
        array[1] = 2;
        return array;
    }

    public static void main(String[] args) {
        int target = 74;
        int[] num = new int[]{448,74,41,680,719,173,774,492,636,199,362,792,74,647,587,678,261,874,467,462,735,582,999,479,34,294,702,834,239,853,349,142,690,81,324,188,813,931,502,707,967,895,445,878,426,430,93,255,304,928,960,192,452,211,495,787,328,568,313,194,608,990,944,256,204,616,44,991,461,59,854,348,611,535,459,724,213,683,777,885,460,751,450,918,806,395,454,603,57,655,110,542,24,82,777,395,877,229,550,685,142,845,139,804,353,111,599,114,679,728,82,137,274,490,340,244,880,982,281,852,568,428,474,348,487,432,749,586,983,402,386,210,300,864,29,980,715,911,738,375,688,515,374,945,513,392,999,214,658,920,695,391,880,600,916,235,384,763,943,399,958,826,663,844,733,461,226,616,536,246,155,83,732,940,392,176,806,925,377,824,465,175,342,291,113,186,410,490,170,32,701,162,471,742,297,791,541,243,885,603,292,933,948,326,894,686,316,341,119,610,276,463,883,849,854,682,304,737,99,760,411,426,445,682,794,541,147,520,576,644,727,499,369,222,226,836,354,53,996,868,37,42,293,271,452,181,219,125,943,149,591,599,972,961,351,545,928,922,376,917,621,777,844,655,151,881,125,877,258,291,566,76,58,18,692,815,448,224,286,191,110,655
        };
        int[] result = towSum(num, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
