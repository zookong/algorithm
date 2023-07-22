package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 요격_시스템 {

    final static int START = 0;
    final static int END = 1;

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        solution(targets);
    }

    public static int solution(int[][] targets) {
        int result = 1;
        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[END]);

        int[] baseTarget = targets[0];
        int targetsLength = targets.length;

        for (int i = 0; i < targetsLength; i++) {
            int[] target = targets[i];

            if (baseTarget[1] <= target[0]) {
                result++;
                baseTarget = target;
            }
        }
        return result;
    }

}
