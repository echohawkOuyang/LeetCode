/**
 * 反转整数
 */

public class Test7_1 {
    public static int reveser(int i) {
        String str = String.valueOf(i);
        StringBuilder result = "-".equals(str.charAt(0)) ? new StringBuilder("-") : new StringBuilder();
        for (int j = str.length() - 1; j >= 0; j--) {
            if (j == 0 && '-' == str.charAt(0)) {
                result.insert(0, '-');
                break;
            }
            result.append(str.charAt(j));
        }
        Long lon = Long.parseLong(result.toString());
        if (lon <= (Math.pow(2, 31) - 1) && lon >= -(Math.pow(2, 31))) {
            return lon.intValue();
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(reveser(1563847412));
        System.out.println(Math.pow(2, 31) - 1);
        System.out.println(-(Math.pow(2, 31)));
    }
}
