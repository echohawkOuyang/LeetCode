public class Test2_1 {
    public String pushDominoes(String dominoes) {
        int leftflag = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'L') {
                if (leftflag != -1) {
                    if ((i - leftflag) % 2 == 0) {
                        for (int j = leftflag; j <= i; j ++) {
                            if (j < leftflag + (i - leftflag) / 2) {

                            }

                        }
                    }
                } else {

                }
            }
        }
    }
}
