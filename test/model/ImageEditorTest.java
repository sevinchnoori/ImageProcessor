package model;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Tests and examples for the image editor model.
 */
public class ImageEditorTest {

  IModel model;

  @Test(expected = IllegalArgumentException.class)
  public void applyWrong() throws IOException {
    this.model = new ImageEditor();
    model.apply("someName", "newName");
  }

  //  @Test(expected = IOException.class)
  //  public void loadWrong() throws IOException {
  //    this.model = new ImageEditor();
  //    model.load("someName", "newName");
  //  }

  @Test(expected = IllegalArgumentException.class)
  public void getWrong() {
    this.model = new ImageEditor();
    model.get("someName");
  }

  @Test(expected = IllegalArgumentException.class)
  public void getPixelWrong() {
    this.model = new ImageEditor();
    model.getPixel(2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void brightenWrong() {
    this.model = new ImageEditor();
    model.brighten(-30, "newname");
  }

  @Test(expected = IllegalArgumentException.class)
  public void darkenWrong() {
    this.model = new ImageEditor();
    model.brighten(-30, "newname");
  }


  @Test
  public void getRowsA() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");
    assertEquals(2, model.getRows());
  }

  @Test
  public void getRowsB() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");
    assertEquals(2, model.getRows());
  }

  @Test
  public void getRowsC() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");
    assertEquals(2, model.getRows());
  }

  @Test
  public void getColsA() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");
    assertEquals(2, model.getCols());
  }

  @Test
  public void getColsB() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");
    assertEquals(2, model.getCols());
  }

  @Test
  public void getColsC() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");
    assertEquals(2, model.getCols());
  }

  // check!!!!!!!!!
  @Test
  public void getPixel() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");
    assertEquals(90, model.getPixel(1, 1).getR());
    assertEquals(10, model.getPixel(0, 0).getR());
    assertEquals(70, model.getPixel(1, 0).getR());
  }

  @Test
  public void redVisual1() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.get("koala.new").getPixel(r, c).getR();
        model.redVisual("koala.new.new");
        int bValNew = model.getPixel(r, c).getB();
        int rValSame = model.getPixel(r, c).getR();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(rVal, bValNew);
        assertEquals(rVal, rValSame);
        assertEquals(rVal, gValNew);
      }
    }
  }

  @Test
  public void redVisual2() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.get("koala.new").getPixel(r, c).getR();
        model.redVisual("koala.new.new");
        int bValNew = model.getPixel(r, c).getB();
        int rValSame = model.getPixel(r, c).getR();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(rVal, bValNew);
        assertEquals(rVal, rValSame);
        assertEquals(rVal, gValNew);
      }
    }
  }

  @Test
  public void redVisual3() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.get("koala.new").getPixel(r, c).getR();
        model.redVisual("koala.new.new");
        int bValNew = model.getPixel(r, c).getB();
        int rValSame = model.getPixel(r, c).getR();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(rVal, bValNew);
        assertEquals(rVal, rValSame);
        assertEquals(rVal, gValNew);
      }
    }
  }

  @Test
  public void greenVisual1() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int gVal = model.get("koala.new").getPixel(r, c).getG();
        model.greenVisual("koala.new.new");
        int rValNew = model.getPixel(r, c).getR();
        int gValSame = model.getPixel(r, c).getG();
        int bValNew = model.getPixel(r, c).getB();

        assertEquals(gVal, rValNew);
        assertEquals(gVal, gValSame);
        assertEquals(gVal, bValNew);
      }
    }
  }

  @Test
  public void greenVisual2() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int gVal = model.get("koala.new").getPixel(r, c).getG();
        model.greenVisual("koala.new.new");
        int rValNew = model.getPixel(r, c).getR();
        int gValSame = model.getPixel(r, c).getG();
        int bValNew = model.getPixel(r, c).getB();

        assertEquals(gVal, rValNew);
        assertEquals(gVal, bValNew);
        assertEquals(gVal, gValSame);
      }
    }
  }

  @Test
  public void greenVisual3() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int gVal = model.get("koala.new").getPixel(r, c).getG();
        model.greenVisual("koala.new.new");
        int rValNew = model.getPixel(r, c).getR();
        int gValSame = model.getPixel(r, c).getG();
        int bValNew = model.getPixel(r, c).getB();

        assertEquals(gVal, rValNew);
        assertEquals(gVal, gValSame);
        assertEquals(gVal, bValNew);
      }
    }
  }

  @Test
  public void blueVisual1() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int bVal = model.get("koala.new").getPixel(r, c).getB();
        model.blueVisual("koala.new.new");
        int rValNew = model.getPixel(r, c).getR();
        int bValSame = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(bVal, rValNew);
        assertEquals(bVal, bValSame);
        assertEquals(bVal, gValNew);
      }
    }
  }

  @Test
  public void blueVisual2() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int bVal = model.get("koala.new").getPixel(r, c).getB();
        model.blueVisual("koala.new.new");
        int rValNew = model.getPixel(r, c).getR();
        int bValSame = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(bVal, rValNew);
        assertEquals(bVal, bValSame);
        assertEquals(bVal, gValNew);
      }
    }
  }

  @Test
  public void blueVisual3() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int bVal = model.get("koala.new").getPixel(r, c).getB();
        model.blueVisual("koala.new.new");
        int rValNew = model.getPixel(r, c).getR();
        int bValSame = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(bVal, rValNew);
        assertEquals(bVal, bValSame);
        assertEquals(bVal, gValNew);
      }
    }
  }

  @Test
  public void brighten1() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").brighten(10, "koala-brighten");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(rValNew, rVal + 10);
        assertEquals(bValNew, bVal + 10);
        assertEquals(gValNew, gVal + 10);
      }
    }
  }


  @Test
  public void brighten2() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").brighten(10, "koala-brighten");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(rValNew, rVal + 10);
        assertEquals(bValNew, bVal + 10);
        assertEquals(gValNew, gVal + 10);
      }
    }
  }

  // brightening becomes above 255
  @Test
  public void brighten3() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        model.get("koala.new").brighten(500, "koala-brighten");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(rValNew, 255);
        assertEquals(bValNew, 255);
        assertEquals(gValNew, 255);
      }
    }
  }

  @Test
  public void darken1() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    int rVal = model.getPixel(0, 0).getR();
    int bVal = model.getPixel(0, 0).getB();
    int gVal = model.getPixel(0, 0).getG();

    model.get("koala.new").darken(1, "koala-darken");

    int rValNew = model.getPixel(0, 0).getR();
    int bValNew = model.getPixel(0, 0).getB();
    int gValNew = model.getPixel(0, 0).getG();

    assertEquals(rValNew, rVal - 1);
    assertEquals(29, bVal - 1);
    assertEquals(gValNew, gVal - 1);

  }

  @Test
  public void darken2() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    int rVal = model.getPixel(0, 0).getR();
    int bVal = model.getPixel(0, 0).getB();
    int gVal = model.getPixel(0, 0).getG();

    model.get("koala.new").darken(10, "koala-darken");

    int rValNew = model.getPixel(0, 0).getR();
    int bValNew = model.getPixel(0, 0).getB();
    int gValNew = model.getPixel(0, 0).getG();

    assertEquals(rValNew, 0);
    assertEquals(bValNew, 20);
    assertEquals(gValNew, 10);
  }


  // goes negative
  @Test
  public void darken3() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        model.get("koala.new").darken(300, "koala-darken");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        assertEquals(rValNew, 0);
        assertEquals(bValNew, 0);
        assertEquals(gValNew, 0);
      }
    }
  }

  @Test
  public void flipVertical() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/vertflip.ppm", "koa");

    int p1 = model.getPixel(0, 0).getX();
    int p2X = model.getPixel(0, 1).getX();
    int p2Y = model.getPixel(0, 1).getY();
    int p3 = model.getPixel(0, 2).getX();
    int p4 = model.getPixel(1, 0).getX();
    int p5X = model.getPixel(1, 1).getX();
    int p5Y = model.getPixel(1, 1).getY();
    int p6 = model.getPixel(1, 2).getX();

    model.get("koa").flipVertical("koala-value");

    int p1NewX = model.getPixel(0, 0).getX();
    int p2NewX = model.getPixel(0, 1).getX();
    int p3NewX = model.getPixel(0, 2).getX();
    int p4NewX = model.getPixel(1, 0).getX();
    int p5NewX = model.getPixel(1, 0).getX();
    int p6NewX = model.getPixel(1, 0).getX();

    int p1NewY = model.getPixel(0, 0).getY();
    int p2NewY = model.getPixel(0, 1).getY();
    int p3NewY = model.getPixel(0, 2).getY();
    int p4NewY = model.getPixel(1, 0).getY();
    int p5NewY = model.getPixel(1, 1).getY();
    int p6NewY = model.getPixel(1, 2).getY();

    assertEquals(p1, p1NewX);
    assertEquals(p2X, p2NewX);
    assertEquals(p3, p3NewX);
    assertEquals(p4, p4NewX);
    assertEquals(p5X, p5NewX);
    assertEquals(p6, p6NewX);
    assertEquals(2, p1NewY);
    assertEquals(p2Y, p2NewY);
    assertEquals(0, p3NewY);
    assertEquals(2, p4NewY);
    assertEquals(p5Y, p5NewY);
    assertEquals(0, p6NewY);

  }

  @Test
  public void flipHorizontal() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/r1c5.ppm", "koala.new");

    int p1 = model.getPixel(0, 0).getY();

    model.get("koala.new").flipHorizontal("koala-value");

    int p1NewX = model.getPixel(0, 0).getX();
    int p1NewY = model.getPixel(0, 0).getY();

    assertEquals(((model.getRows() - 1)), p1NewX);
    assertEquals(p1, p1NewY);

  }


  @Test
  public void setIntensity1() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").setIntensity("koala-value");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        int average = ((rVal + bVal + gVal) / 3);

        assertEquals(average, rValNew);
        assertEquals(average, bValNew);
        assertEquals(average, gValNew);
      }
    }
  }

  @Test
  public void setIntensity2() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").setIntensity("koala-value");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        int average = ((rVal + bVal + gVal) / 3);

        assertEquals(average, rValNew);
        assertEquals(average, bValNew);
        assertEquals(average, gValNew);
      }
    }
  }

  @Test
  public void setIntensity3() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").setIntensity("koala-value");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        int average = ((rVal + bVal + gVal) / 3);

        assertEquals(average, rValNew);
        assertEquals(average, bValNew);
        assertEquals(average, gValNew);
      }
    }
  }

  @Test
  public void setValue1() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").setValue("koala-value");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        int halfMax = Math.max(rVal, bVal);
        int max = Math.max(halfMax, gVal);

        assertEquals(max, rValNew);
        assertEquals(max, bValNew);
        assertEquals(max, gValNew);
      }
    }
  }

  @Test
  public void setValue2() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").setValue("koala-value");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        int halfMax = Math.max(rVal, bVal);
        int max = Math.max(halfMax, gVal);

        assertEquals(max, rValNew);
        assertEquals(max, bValNew);
        assertEquals(max, gValNew);
      }
    }
  }

  @Test
  public void setValue3() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").setValue("koala-value");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        int halfMax = Math.max(rVal, bVal);
        int max = Math.max(halfMax, gVal);

        assertEquals(max, rValNew);
        assertEquals(max, bValNew);
        assertEquals(max, gValNew);
      }
    }
  }

  @Test
  public void setLuma() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").setLuma("koala-value");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        int luma = (int) Math.round((.2126 * rVal) + (.7152 * bVal) + (.0722 * gVal));

        assertEquals(luma, rValNew);
        assertEquals(luma, bValNew);
        assertEquals(luma, gValNew);
      }
    }
  }

  @Test
  public void setLuma2() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").setLuma("koala-value");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        int luma = (int) Math.round((.2126 * rVal) + (.7152 * bVal) + (.0722 * gVal));

        assertEquals(luma, rValNew);
        assertEquals(luma, bValNew);
        assertEquals(luma, gValNew);
      }
    }
  }

  @Test
  public void setLuma3() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");

    for (int c = 0; c < model.getCols(); c = c + 1) {
      for (int r = 0; r < model.getRows(); r = r + 1) {

        int rVal = model.getPixel(r, c).getR();
        int bVal = model.getPixel(r, c).getB();
        int gVal = model.getPixel(r, c).getG();

        model.get("koala.new").setLuma("koala-value");

        int rValNew = model.getPixel(r, c).getR();
        int bValNew = model.getPixel(r, c).getB();
        int gValNew = model.getPixel(r, c).getG();

        int luma = (int) Math.round((.2126 * rVal) + (.7152 * bVal) + (.0722 * gVal));

        assertEquals(luma, rValNew);
        assertEquals(luma, bValNew);
        assertEquals(luma, gValNew);
      }
    }
  }

  @Test
  public void blur() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");


    model.get("koala.new").apply("blur", "img-blur");
    int rNew0 = model.getPixel(0, 0).getR();
    int gNew0 = model.getPixel(0, 0).getG();
    int bNew0 = model.getPixel(0, 0).getB();

    int rNew2 = model.getPixel(1, 1).getR();
    int gNew2 = model.getPixel(1, 1).getG();
    int bNew2 = model.getPixel(1, 1).getB();


    assertEquals(18, rNew0);
    assertEquals(20, gNew0);
    assertEquals(17, bNew0);

    assertEquals(33, rNew2);
    assertEquals(24, gNew2);
    assertEquals(17, bNew2);

  }

  @Test
  public void sharpen() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");


    model.get("koala.new").apply("sharpen", "img-blur");
    int rNew0 = model.getPixel(0, 0).getR();
    int gNew0 = model.getPixel(0, 0).getG();
    int bNew0 = model.getPixel(0, 0).getB();

    int rNew2 = model.getPixel(1, 1).getR();
    int gNew2 = model.getPixel(1, 1).getG();
    int bNew2 = model.getPixel(1, 1).getB();


    assertEquals(53, rNew0);
    assertEquals(55, gNew0);
    assertEquals(53, bNew0);

    assertEquals(113, rNew2);
    assertEquals(70, gNew2);
    assertEquals(53, bNew2);

  }

  @Test
  public void greyscale() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");


    model.get("koala.new").greyscale("new");
    int rNew0 = model.getPixel(0, 0).getR();
    int gNew0 = model.getPixel(0, 0).getG();
    int bNew0 = model.getPixel(0, 0).getB();

    int rNew2 = model.getPixel(1, 1).getR();
    int gNew2 = model.getPixel(1, 1).getG();
    int bNew2 = model.getPixel(1, 1).getB();


    assertEquals(19, rNew0);
    assertEquals(19, gNew0);
    assertEquals(19, bNew0);

    assertEquals(50, rNew2);
    assertEquals(50, gNew2);
    assertEquals(50, bNew2);

  }

  @Test
  public void sepia() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "koala.new");


    model.get("koala.new").sepia("new");
    int rNew0 = model.getPixel(0, 0).getR();
    int gNew0 = model.getPixel(0, 0).getG();
    int bNew0 = model.getPixel(0, 0).getB();

    int rNew2 = model.getPixel(1, 1).getR();
    int gNew2 = model.getPixel(1, 1).getG();
    int bNew2 = model.getPixel(1, 1).getB();


    assertEquals(25, rNew0);
    assertEquals(22, gNew0);
    assertEquals(17, bNew0);

    assertEquals(72, rNew2);
    assertEquals(64, gNew2);
    assertEquals(50, bNew2);

  }


}


