package controller;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests and examples for the ImageUtil class.
 */
public class ImageUtilTest {

  @Test
  public void readPPM() throws FileNotFoundException {
    Pixel[][] pix = ImageUtil.readPPM("./src/images/img.ppm");
    assertEquals(2, pix.length);
    assertEquals(2, pix[0].length);
    assertEquals(10, pix[0][0].getR());
    assertEquals(20, pix[0][0].getG());
    assertEquals(30, pix[0][0].getB());
    assertEquals(10, pix[0][1].getR());
    assertEquals(50, pix[0][1].getG());
    assertEquals(30, pix[0][1].getB());
    assertEquals(70, pix[1][0].getR());
    assertEquals(50, pix[1][0].getG());
    assertEquals(30, pix[1][0].getB());
    assertEquals(90, pix[1][1].getR());
    assertEquals(40, pix[1][1].getG());
    assertEquals(30, pix[1][1].getB());
  }

  @Test
  public void readPPM2() throws FileNotFoundException {
    Pixel[][] pix = ImageUtil.readPPM("./src/images/b.ppm");
    assertEquals(3, pix.length);
    assertEquals(2, pix[0].length);
    assertEquals(1, pix[0][0].getR());
    assertEquals(2, pix[0][0].getG());
    assertEquals(3, pix[0][0].getB());
    assertEquals(9, pix[0][1].getR());
    assertEquals(4, pix[0][1].getG());
    assertEquals(3, pix[0][1].getB());
    assertEquals(7, pix[1][0].getR());
    assertEquals(5, pix[1][0].getG());
    assertEquals(3, pix[1][0].getB());
    assertEquals(7, pix[1][1].getR());
    assertEquals(4, pix[1][1].getG());
    assertEquals(9, pix[1][1].getB());
  }

  @Test
  public void read() throws IOException {
    Pixel[][] pix = ImageUtil.read("./res/google.jpg");
    assertEquals(300, pix.length);
    assertEquals(300, pix[0].length);
    assertEquals(255, pix[0][0].getR());
    assertEquals(255, pix[0][0].getG());
    assertEquals(255, pix[0][0].getB());
    assertEquals(255, pix[0][1].getR());
    assertEquals(255, pix[0][1].getG());
    assertEquals(255, pix[0][1].getB());
    assertEquals(255, pix[1][0].getR());
    assertEquals(255, pix[1][0].getG());
    assertEquals(255, pix[1][0].getB());
    assertEquals(255, pix[1][1].getR());
    assertEquals(255, pix[1][1].getG());
    assertEquals(255, pix[1][1].getB());

  }

  @Test
  public void read2() throws IOException {
    Pixel[][] pix = ImageUtil.read("./res/notepad.load.png");
    assertEquals(256, pix.length);
    assertEquals(256, pix[0].length);
    assertEquals(0, pix[0][0].getR());
    assertEquals(0, pix[0][0].getG());
    assertEquals(0, pix[0][0].getB());
    assertEquals(0, pix[0][1].getR());
    assertEquals(0, pix[0][1].getG());
    assertEquals(0, pix[0][1].getB());
    assertEquals(0, pix[1][0].getR());
    assertEquals(0, pix[1][0].getG());
    assertEquals(0, pix[1][0].getB());
    assertEquals(0, pix[1][1].getR());
    assertEquals(0, pix[1][1].getG());
    assertEquals(0, pix[1][1].getB());
  }

  @Test
  public void read3() throws IOException {
    Pixel[][] pix = ImageUtil.read("./res/NERD.bmp");
    assertEquals(10, pix.length);
    assertEquals(10, pix[0].length);
    assertEquals(0, pix[0][0].getR());
    assertEquals(104, pix[0][0].getG());
    assertEquals(207, pix[0][0].getB());
    assertEquals(0, pix[0][1].getR());
    assertEquals(115, pix[0][1].getG());
    assertEquals(230, pix[0][1].getB());
    assertEquals(0, pix[1][0].getR());
    assertEquals(115, pix[1][0].getG());
    assertEquals(230, pix[1][0].getB());
    assertEquals(0, pix[1][1].getR());
    assertEquals(128, pix[1][1].getG());
    assertEquals(255, pix[1][1].getB());
  }
}