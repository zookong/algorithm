package programmers.level2;

public class 두_원_사이의_정수_쌍 {
    public static void main(String[] args) {
        int r1 = 2, r2 = 3;

        System.out.println(
                pointCountOnXy(r1, r2) + pointCountOnOneQuadrant(r1, r2)
        );
    }

    private static long pointCountOnXy(long r1, long r2) {
        long diff = r2 - r1 + 1;
        return 4 * diff;
    }

    private static long pointCountOnOneQuadrant(long r1, long r2) {
        long result = 0;

        for (long i = 1; i < r2; i++) {
            int r2MaxY = getR2MaxY(r2, i);
            if (i < r1) {
                int r1MaxY = getR1MaxY(r1, i);
                result += r2MaxY - r1MaxY;
            } else {
                result += r2MaxY;
            }
        }
        return 4 * result;
    }

    private static int getR1MaxY(long r, long x) {
        double maxY = Math.sqrt(r * r - x * x);
        int maxYInt = (int) maxY;
        if (maxY - maxYInt == 0.0) {
            return maxYInt - 1;
        } else {
            return maxYInt;
        }
    }

    private static int getR2MaxY(long r, long x) {
        double maxY = Math.sqrt(r * r - x * x);
        return (int) maxY;
    }

//    private int pointCountOnOneQuadrant(int r1, int r2) {
//        int result = 0;
//
//        for (int i = 1; i <= r2; i++) {
//            double r1theta = Math.acos((double) i / r1);
//            double r2theta = Math.acos((double) i / r2);
//
//            double min = Double.isNaN(r1theta) ? 1 : r1 * Math.sin(r1theta);
//            min = min < 1 ? 1 : min;
//            double max = r2 * Math.sin(r2theta);
//
//            max = Math.floor(max);
//            min = Math.ceil(min);
//
//            if(max < min)
//                continue;
//
//            result = result + (int) (max - min + 1);
//        }
//        return 4 * result;
//    }

//    private static int pointCountOnOneQuadrant(int r1, int r2) {
//        int result = 0;
//
//
//        double r1square = Math.pow(r1, 2);
//        double r2square = Math.pow(r2, 2);
//        for (int i = 1; i <= r2; i++) {
//            for (int j = 1; j < r2; j++) {
//                double disSquare = Math.pow(i, 2) + Math.pow(j, 2);
//                if (r1square <= disSquare && disSquare <= r2square) {
//                    ++result;
//                }
//            }
//        }
//        return 4 * result;
//    }


}
