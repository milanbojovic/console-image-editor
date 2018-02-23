package com.onthemarket.editor;

public class Simulator {

    private Image image = null;

    public Simulator() {}

    public String drawMenu() {
        return "Supported commands:\n" +
                "1. I M N . Create a new M x N image with all pixels coloured white (O).\n" +
                "2. C . Clears the table, setting all pixels to white (O).\n" +
                "3. L X Y C . Colours the pixel (X,Y) with colour C.\n" +
                "4. V X Y1 Y2 C . Draw a vertical segment of colour C in column X between rows Y1 and Y2 (inclusive).\n" +
                "5. H X1 X2 Y C . Draw a horizontal segment of colour C in row Y between columns X1 and X2 (inclusive).\n" +
                "6. F X Y C . Fill the region R with the colour C. R is defined as: Pixel (X,Y) belongs to R. Any other pixel which is the same colour as (X,Y) and shares a common side with any pixel in R also belongs to this region.\n" +
                "7. S . Show the contents of the current image\n" +
                "8. X . Terminate the session\n";
    }

    public void parseAndExecute(String line) {
        if (line != null && line.trim().length() != 0) {
            char command = line.charAt(0);

            switch (command) {
                case 'I':
                    int m = Integer.valueOf(splitLine(line)[1]);
                    int n = Integer.valueOf(splitLine(line)[2]);

                    image = new Image(m, n);
                    break;
                case 'C':
                    if (image != null) {
                        image.clearImage();
                    } else {
                        System.out.println("Error - image must be created before editing");
                    }
                    break;
                case 'L':
                    if (image != null) {
                        int x = Integer.valueOf(splitLine(line)[1]);
                        int y = Integer.valueOf(splitLine(line)[2]);
                        char colour = splitLine(line)[3].charAt(0);
                        image.drawPixel(x, y, colour);
                    } else {
                        System.out.println("Error - image must be created before editing");
                    }
                    break;
                case 'V':
                    if (image != null) {
                        int x = Integer.valueOf(splitLine(line)[1]);
                        int y1 = Integer.valueOf(splitLine(line)[2]);
                        int y2 = Integer.valueOf(splitLine(line)[3]);
                        char colour = splitLine(line)[4].charAt(0);

                        image.drawVerticalLine(x, y1, y2, colour);
                    } else {
                        System.out.println("Error - image must be created before editing");
                    }
                    break;
                case 'H':
                    if (image != null) {
                        int x1 = Integer.valueOf(splitLine(line)[1]);
                        int x2 = Integer.valueOf(splitLine(line)[2]);
                        int y = Integer.valueOf(splitLine(line)[3]);
                        char colour = splitLine(line)[4].charAt(0);

                        image.drawHorizontalLine(x1, x2, y, colour);
                    } else {
                        System.out.println("Error - image must be created before editing");
                    }
                    break;
                case 'F':
                    if (image != null) {
                        int x = Integer.valueOf(splitLine(line)[1]);
                        int y = Integer.valueOf(splitLine(line)[2]);
                        char colour = splitLine(line)[3].charAt(0);

                        image.fillRegion(x, y, colour, 'x');
                    } else {
                        System.out.println("Error - image must be created before editing");
                    }
                    break;
                case 'S':
                    if (image != null) {
                        System.out.println(image);
                    } else {
                        System.out.println("Error - image must be created before printing");
                    }
                    break;
                case 'X':
                    System.out.println("Closing image editor!");
                    System.exit(0);
                    break;
            }
        }
    }

    private String[] splitLine(String line) {
        return line.replaceAll("\\s+", " ").split(" ");
    }
}
