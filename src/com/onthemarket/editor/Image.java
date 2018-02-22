package com.onthemarket.editor;

public class Image {
    private final int M, N;
    private char[][] data;

    public Image(int m, int n) {
        M = m;
        N = n;

        data = new char[M][N];

        clearImage();
    }

    private void clearImage() {
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                data[m][n] = 'O';
            }
        }
    }

    public void drawPixel(int x, int y, char colour) {
        x--;
        y--;

        data[x][y] = colour;
    }

    public void drawVerticalLine(int x, int y1, int y2, char colour) {
        x--;
        y1--;
        y2--;

        for (int xx = x, yy = y1; yy <= y2; yy++) {
            data[xx][yy] = colour;
        }
    }

    public void drawHorizontalLine(int x1, int x2, int y, char colour) {
        y--;
        x1--;
        x2--;

        for (int yy = y, xx = x1; xx <= x2; xx++) {
            data[xx][yy] = colour;
        }
    }

    public void fillRegion(int x, int y, char newColour, char baseColour) {
        if (baseColour == 'x') {
            x--;
            y--;
            baseColour = data[x][y];
        } else {
            if (x < 0 || y < 0 || x > M - 1 || y > N - 1 ) return;
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
}
