/**
 *将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 *
 * 实现一个将字符串进行指定行数变换的函数:
 *
 * string convert(string s, int numRows);
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用一个最笨的雏形
 *
 * 还有边界之没考虑
 *
 *21%
 *
 *
 * 还有直接通过公式计算下一个，就能直接取了
 */
public class Test6_1 {
    public static String convert(String s, int numRows) {
        Map<Integer, List<Character>> map = new HashMap<>();
        boolean flag = true;
        int key = 1;
        if (numRows == 1) {
            return s;
        }
        for (int i = 1; i <= numRows; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int j = 0; j < s.length(); j++) {
            if (flag) {
                map.get(key).add(s.charAt(j));
                if (key == numRows) {
                    flag = false;
                    key--;
                } else {
                    key++;
                }
            } else {
                map.get(key).add(s.charAt(j));
                if (key == 1) {
                    flag = true;
                    key++;
                } else {
                    key--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            List<Character> list = map.get(i);
            for (Character c:
                 list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}
