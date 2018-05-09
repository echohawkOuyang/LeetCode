import java.util.ArrayList;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *The final answer should be in lexicographic order.
 */


public class Competition001_1 {
    public static List<List<Integer>> largeGroupPositions(String S) {
        boolean flag = false;
        int start = 0;
        char fundation = S.charAt(0);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0;i <= S.length();i++) {
            if (i == S.length()||fundation != S.charAt(i)) {
                if (i - start > 2) {
                    List<Integer> list1 = new ArrayList();
                    list1.add(start);
                    list1.add(i - 1);
                    list.add(list1);
                }
                if (i != S.length()) {
                    start = i;
                    fundation = S.charAt(i);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        for (List<Integer> i:
        largeGroupPositions("aaa")) {
            System.out.println(i);
        }
    }
}
