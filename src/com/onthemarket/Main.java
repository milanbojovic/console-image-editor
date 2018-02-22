package com.onthemarket;

import com.onthemarket.editor.Image;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("Image editor started, please choose your option: ");

        Image image = new Image(5,6);

        image.drawPixel(2, 3, 'A');

        System.out.println(image);

        image.drawPixel(1, 5, 'P');
        image.drawHorizontalLine(2, 5, 5, 'B');

        image.fillRegion(3,3,'J', 'x');
        image.drawVerticalLine(2, 3, 4, 'W');
        image.drawHorizontalLine(3,4,2,'Z');


        System.out.println(image);

    }
}
