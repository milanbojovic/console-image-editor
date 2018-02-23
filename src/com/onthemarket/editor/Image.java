package com.onthemarket.editor;

public class Image {
    private final int M, N;
    private char[][] data;

    public char getData(int x, int y) {
        validateRange(x, y);
        x--;
        y--;
        return data[x][y];
    }

    public Image(int m, int n) {
        M = m;
        N = n;
        validateRange(m, n);

        data = new char[M][N];
        clearImage();
    }

    public void clearImage() {
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                data[m][n] = 'O';
            }
        }
    }

    public void drawPixel(int x, int y, char colour) {
        validateRange(x, y);
        validateColour(colour);

        x--;
        y--;

        data[x][y] = colour;
    }

    public void drawVerticalLine(int x, int y1, int y2, char colour) {
        validateRange(x, y1, y2);
        validateColour(colour);

        x--;
        y1--;
        y2--;

        for (int xx = x, yy = y1; yy <= y2; yy++) {
            data[xx][yy] = colour;
        }
    }

    public void drawHorizontalLine(int x1, int x2, int y, char colour) {
        validateRange(x1, x2, y);
        validateColour(colour);

        y--;
        x1--;
        x2--;

        for (int yy = y, xx = x1; xx <= x2; xx++) {
            data[xx][yy] = colour;
        }
    }

    public void fillRegion(int x, int y, char newColour, char baseColour) {
        if (baseColour == 'x') {
            validateRange(x, y);
            validateColour(newColour);
            x--;
            y--;
            baseColour = data[x][y];
        } else {
            if (x < 0 || y < 0 || x > M - 1 || y > N - 1) return;
            if (data[x][y] != baseColour) return;
        }
        data[x][y] = newColour;

        //left
        fillRegion(x - 1, y, newColour, baseColour);
        //right
        fillRegion(x + 1, y, newColour, baseColour);
        //up
        fillRegion(x, y - 1, newColour, baseColour);
        //down
        fillRegion(x, y + 1, newColour, baseColour);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                sb.append(data[m][n]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void validateRange(int... args) {
        for (int arg : args) {
            if (arg < 1 || arg > 250)
                throw new IllegalArgumentException("Error - Table range validation failed: allowed range: [1, 250].");
        }
    }

    private void validateColour(char colour) {
        if (!Character.isLetter(colour) || !Character.isUpperCase(colour))
            throw new IllegalArgumentException("Error - Colour validation failed: Colour must be capital letter !!!");
    }
}
