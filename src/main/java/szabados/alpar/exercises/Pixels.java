package szabados.alpar.exercises;

import java.util.Arrays;

/**
 * <p>Given a screen with all pixels having one of two colors. Now I will click on a random pixel.
 * <br>Then that pixel &amp; all the adjacent pixels with same color should change the color to the second getColor.
 * <br>
 * <br>adjacent = vertically or horizontally above or blow.
 * <br>
 * <br>Edit: Question seem to be not clear to some ppl. Giving an ex:
 * <br>
 * <br>Given below &amp; clicked on 2nd row, 2nd col
 * <br>W B W W B W
 * <br>B B W W B W
 * <br>W B B B W B
 * <br>W B W W B B
 * <br>
 * <br>Covert to
 * <br>W W W W B W
 * <br>W W W W B W
 * <br>W W W W W B
 * <br>W W W W B B</p>
 */
public class Pixels {
    public static void main(String[] args) {
        boolean[][] input = {
                {true, false, true, true, false, true},
                {false, false, true, true, false, true},
                {true, false, false, false, true, false},
                {true, false, true, true, false, false}
        };

        boolean[][] expected = {
                {true, true, true, true, false, true},
                {true, true, true, true, false, true},
                {true, true, true, true, true, false},
                {true, true, true, true, false, false}
        };

        Click click = new Click(1, 1);
        boolean clickColor = click.getColor(input);
        Pixels.changeColour(input, click, clickColor);

        assert Arrays.deepEquals(input, expected);
    }

    private static void changeColour(boolean[][] input, Click click, boolean clickColor) {
        if (click.isValid(input, clickColor)) {
            input[click.row][click.col] = !clickColor;
            for (int i = -1; i <= 1; i += 2) {
                changeColour(input, new Click(click.row + i, click.col), clickColor);
                changeColour(input, new Click(click.row, click.col + i), clickColor);
            }
        }
    }
}

class Click {
    final int row, col;

    Click(int row, int col) {
        this.row = row;
        this.col = col;
    }

    boolean isValid(boolean[][] input, boolean clickColor) {
        return row >= 0 && row < input.length
                && col >= 0 && col < input[row].length
                && input[row][col] == clickColor;
    }

    boolean getColor(boolean[][] input) {
        return input[row][col];
    }
}
