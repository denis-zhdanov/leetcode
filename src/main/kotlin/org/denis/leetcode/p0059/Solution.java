package org.denis.leetcode.p0059;

public class Solution {

    public static void main(String[] args) {
        int[][] result = new Solution().generateMatrix(4);
        for (int[] ints : result) {
            for (int i : ints) {
                System.out.printf("%2d ", i);
            }
            System.out.println();
        }
    }

    private static final State TOP    = new State(true, 1, 0, 0, 0, 0, 0);
    private static final State RIGHT  = new State(true, 0, 1, 0, 0, 0, 0);
    private static final State BOTTOM = new State(false, -1, 0, 0, 0, 1, -1);
    private static final State LEFT   = new State(false, 0, -1, 1, -1, 0, 0);

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        State state = TOP;
        int lowRowLimit = -1;
        int highRowLimit = n;
        int row = 0;
        int lowColumnLimit = -1;
        int highColumnLimit = n;
        int column = 0;
        int counter = 0;
        while (row > lowRowLimit && row < highRowLimit && column > lowColumnLimit && column < highColumnLimit) {
            int currentRowLimit;
            int currentColumnLimit;
            if (state.naturalOrder) {
                currentRowLimit = highRowLimit;
                currentColumnLimit = highColumnLimit;
            } else {
                currentRowLimit = lowRowLimit;
                currentColumnLimit = lowColumnLimit;
            }
            for (; row != currentRowLimit
                   && column != currentColumnLimit; row += state.rowIncrement, column += state.columnIncrement) {
                result[row][column] = ++counter;
            }
            row -= state.rowIncrement;
            column -= state.columnIncrement;
            lowRowLimit += state.startRowChange;
            highRowLimit += state.endRowChange;
            lowColumnLimit += state.startColumnChange;
            highColumnLimit += state.endColumnChange;
            state = next(state);
            row += state.rowIncrement;
            column += state.columnIncrement;
        }
        return result;
    }

    private static State next(State current) {
        if (current == TOP) {
            return RIGHT;
        } else if (current == RIGHT) {
            return BOTTOM;
        } else if (current == BOTTOM) {
            return LEFT;
        } else if (current == LEFT) {
            return TOP;
        }
        throw new IllegalArgumentException();
    }

    private static class State {
        public final boolean naturalOrder;
        public final int     columnIncrement;
        public final int     rowIncrement;
        public final int     startColumnChange;
        public final int     endColumnChange;
        public final int     startRowChange;
        public final int     endRowChange;

        public State(boolean naturalOrder,
                     int columnIncrement,
                     int rowIncrement,
                     int startColumnChange,
                     int endColumnChange,
                     int startRowChange,
                     int endRowChange)
        {
            this.naturalOrder = naturalOrder;
            this.columnIncrement = columnIncrement;
            this.rowIncrement = rowIncrement;
            this.startColumnChange = startColumnChange;
            this.endColumnChange = endColumnChange;
            this.startRowChange = startRowChange;
            this.endRowChange = endRowChange;
        }
    }
}
