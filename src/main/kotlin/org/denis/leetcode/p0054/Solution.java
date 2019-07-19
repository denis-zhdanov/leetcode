package org.denis.leetcode.p0054;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][] {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
                {1,  2,  3, 4},
                {5,  6,  7, 8},
                {9, 10, 11, 12}
        }));
    }

    public static final State TOP = new State(true, 1, 0, 0, 0, 0, 0);
    public static final State RIGHT = new State(true, 0, 1, 0, 0, 0, 0);
    public static final State BOTTOM = new State(false, -1, 0, 0, 0, 1, -1);
    public static final State LEFT = new State(false, 0, -1, 1, -1, 0, 0);

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        State state = TOP;
        int lowRowLimit = -1;
        int highRowLimit = matrix.length;
        int row = 0;
        int lowColumnLimit = -1;
        int highColumnLimit = matrix[0].length;
        int column = 0;
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
            for (; row != currentRowLimit && column != currentColumnLimit; row += state.rowIncrement, column += state.columnIncrement) {
                result.add(matrix[row][column]);
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

    static class State {
        public final boolean naturalOrder;
        public final int columnIncrement;
        public final int rowIncrement;
        public final int startColumnChange;
        public final int endColumnChange;
        public final int startRowChange;
        public final int endRowChange;

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
