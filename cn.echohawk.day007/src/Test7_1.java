/**
 * 反转整数
 */

public class Test7_1 {
    public int reveser(int i) {
        String str = String.valueOf(i);
        StringBuilder result = "-".equals(str.charAt(0)) ? new StringBuilder("-") : new StringBuilder();
        for (int j = str.length() - 1; j >= 0; j++) {
            if (j == 0 && "-".equals(str.charAt(0))) {
                break;
            }
            result.append(str.charAt(j));
        }
        Long lon = Long.parseLong(result.toString());
        if (lon <= (2^31 - 1) && lon >= -(2^31)) {
            return lon.intValue();
        } else {
            return 0;
        }
    }
}
