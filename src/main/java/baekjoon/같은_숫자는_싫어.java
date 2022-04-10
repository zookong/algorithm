package baekjoon;

// https://programmers.co.kr/learn/courses/30/lessons/12906?language=java
public class 같은_숫자는_싫어 {

    public static void main(String[] args) {
        int[] test1 = {1, 1, 3, 3, 0, 1, 1};
        int[] test2 = {4, 4, 4, 3, 3};

        solution(test1);
        solution(test2);

    }

    public static int[] solution(int[] arr) {
        int resultLength = 1;

        int length = arr.length;
        int nextIdx = -1;

        for (int idx = 0; idx < length - 1; idx++) {
            nextIdx = idx + 1;

            if (arr[idx] == arr[nextIdx]) {
                arr[idx] = -1;
            } else {
                ++resultLength;
            }
        }

        int[] res = new int[resultLength];
        int resIdx = 0;
        for (int ele : arr) {

            if (ele != -1) {
                res[resIdx] = ele;
                ++resIdx;
            }

        }

        return res;
    }


}
