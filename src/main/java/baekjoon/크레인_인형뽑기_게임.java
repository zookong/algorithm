package baekjoon;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
public class 크레인_인형뽑기_게임 {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 1, 5, 5, 3, 2, 2};

        solution(board, moves);
    }

    static int solution(int[][] board, int[] moves) {
        IntVerticalStack intVerticalStack = new IntVerticalStack();
        int answer = 0, boardLength = board.length, movesLength = moves.length;

        for (int midx = 0; midx < movesLength; midx++) {
            int moveIdx = moves[midx] - 1;

            for (int bidx = 0; bidx < boardLength; bidx++) {
                int doll = board[bidx][moveIdx];

                // 해당 인덱스에 인형이 없음.
                if (doll == 0)
                    continue;

                board[bidx][moveIdx] = 0;

                // 해당 인덱스에 인형이 있음.
                if (intVerticalStack.equalsTop(doll)) {
                    answer += 2;
                    intVerticalStack.pop();
                } else {
                    intVerticalStack.add(doll);
                }

                // 인형을 뽑았으니 해당 for문 제거
                break;

            }

        }

        return answer;
    }

    static class IntVerticalStack {

        IntNode top;

        boolean equalsTop(int value) {
            if (top == null || top.value == -1)
                return false;
            return top.value == value;
        }

        void add(int value) {
            IntNode next = new IntNode(value, null, this.top);

            if (top != null)
                this.top.next = next;

            this.top = next;
        }

        boolean pop() {

            if (this.top == null)
                return false;

            this.top = this.top.previous;

            return true;
        }

        class IntNode {

            public IntNode(int value, IntNode next, IntNode previous) {
                this.value = value;
                this.next = next;
                this.previous = previous;
            }

            int value = -1;
            IntNode next;
            IntNode previous;
        }

    }


}