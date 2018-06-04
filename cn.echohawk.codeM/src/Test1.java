import java.math.BigDecimal;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> discountlist = new ArrayList<>();
        List<Integer> nodiscountList = new ArrayList<>();
        Map<Integer, Integer> fullcount = new HashMap();
        int row = 1;
        int discountRow = 0, fullcountRow = 0;
        while (in.hasNextInt()) {//数据的封装
            if (row == 1) {
                discountRow = in.nextInt();
                fullcountRow = in.nextInt();
            } else if (row <= discountRow + 1) {
                Integer price = in.nextInt();
                if (in.nextInt() == 0) {
                    nodiscountList.add(price);
                } else {
                    discountlist.add(price);
                }
            } else if (row <= discountRow + fullcountRow + 1){
                fullcount.put(in.nextInt(), in.nextInt());
            }
        }
        Integer totle = new Integer("0");
        BigDecimal bigDecimal = new BigDecimal("0");
        Collections.sort(discountlist);
        for (int i = 0; i < )
        bigDecimal.abs();
    }


}

