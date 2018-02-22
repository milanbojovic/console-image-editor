package com.onthemarket.test;

import com.onthemarket.editor.Image;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.Assert.*;

public class ImageTest {

    Image image = null;

    @org.junit.Before
    public void setUp() throws Exception {
        image = new Image(5,6);
    }

    @org.junit.Test
    public void NewImage() {
        Assert.that(image.toString().equals("OOOOO\nOOOOO\nOOOOO\nOOOOO\nOOOOO\nOOOOO\n"), "Error - image is not in expected format.");
    }

    @org.junit.Test
    public void drawPixel() {
        image.drawPixel(3, 3, 'A');

        Assert.that(image.getData(3,3) == 'A', "Error - image validation failed");
    }

    @org.junit.Test
    public void drawVerticalLine() {
        image.drawVerticalLine(2, 3, 4, 'W');

        Assert.that(image.getData(2,3) == 'W', "Error - image validation failed");
        Assert.that(image.getData(2,4) == 'W', "Error - image validation failed");
    }

    @org.junit.Test
    public void drawHorizontalLine() {
        image.drawHorizontalLine(1, 5, 5, 'S');

        Assert.that(image.getData(1,5) == 'S', "Error - image validation failed");
        Assert.that(image.getData(2,5) == 'S', "Error - image validation failed");
        Assert.that(image.getData(3,5) == 'S', "Error - image validation failed");
        Assert.that(image.getData(4,5) == 'S', "Error - image validation failed");
        Assert.that(image.getData(5,5) == 'S', "Error - image validation failed");
    }

    @org.junit.Test
    public void fillRegion() {
        image.drawHorizontalLine(1, 5, 2, 'H');
        image.fillRegion(1,1, 'Q', 'x');

        Assert.that(image.getData(1,1) == 'Q', "Error - image validation failed");
        Assert.that(image.getData(2,1) == 'Q', "Error - image validation failed");
        Assert.that(image.getData(3,1) == 'Q', "Error - image validation failed");
        Assert.that(image.getData(4,1) == 'Q', "Error - image validation failed");
        Assert.that(image.getData(5,1) == 'Q', "Error - image validation failed");

        Assert.that(image.getData(1,2) == 'H', "Error - image validation failed");
        Assert.that(image.getData(2,2) == 'H', "Error - image validation failed");
        Assert.that(image.getData(3,2) == 'H', "Error - image validation failed");
        Assert.that(image.getData(4,2) == 'H', "Error - image validation failed");
        Assert.that(image.getData(5,2) == 'H', "Error - image validation failed");
    }
}