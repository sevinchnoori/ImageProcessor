package view;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import model.IModel;
import model.ImageEditor;


/**
 * Tests and examples for the text view class.
 */
public class TextViewTest {

  private IModel model;


  private IView view;
  private Appendable dest;


  // invalid constructor of 1 argument - model
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    this.model = null;
    this.view = new TextView(this.model);
  }

  // invalid constructor of 2 arguments - model and appendable
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2A() {
    this.model = null;
    this.dest = new StringBuilder();
    this.view = new TextView(this.model, dest);
  }

  // invalid constructor of 2 arguments - model and appendable
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2B() {
    this.model = new ImageEditor();
    this.dest = null;
    this.view = new TextView(this.model, dest);
  }

  // tests an IOexception thrown while rendering a message
  @Test
  public void testRenderMessage() throws IOException {
    this.model = new ImageEditor();
    this.view = new TextView(model, new view.CorruptClass());
    try {
      view.renderMessage("sup");
      Assert.fail("IOException thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // tests an IOexception thrown while rendering a message
  @Test
  public void testRenderMessage2() throws IOException {
    this.model = new ImageEditor();
    this.view = new TextView(model, new view.CorruptClass());
    try {
      view.renderMessage("hello");
      Assert.fail("IOException thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // tests an IOexception thrown while rendering a message
  @Test
  public void testRenderMessage3() throws IOException {
    this.model = new ImageEditor();
    this.view = new TextView(model, new view.CorruptClass());
    try {
      view.renderMessage("bye");
      Assert.fail("IOException thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // tests an IOexception thrown while rendering a board
  @Test
  public void testRenderImage() throws IOException {
    this.model = new ImageEditor();
    this.model.load("./src/images/img.ppm", "visualize.txt");
    this.view = new TextView(this.model, new view.CorruptClass());
    try {
      this.view.renderImage();
      Assert.fail("IOException thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // tests an IOexception thrown while rendering a board
  @Test
  public void testRenderImage2() throws IOException {
    this.model = new ImageEditor();
    this.model.load("./src/images/b.ppm", "visualize.txt");
    this.view = new TextView(this.model, new view.CorruptClass());
    try {
      this.view.renderImage();
      Assert.fail("IOException thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // tests an IOexception thrown while rendering a board
  @Test
  public void testRenderImage3() throws IOException {
    this.model = new ImageEditor();
    this.model.load("./src/images/vertflip.ppm", "visualize.txt");
    this.view = new TextView(this.model, new view.CorruptClass());
    try {
      this.view.renderImage();
      Assert.fail("IOException thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // tests visualize
  @Test
  public void testVisualize() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/img.ppm", "visualize.txt");
    this.dest = new StringBuilder();
    view = new TextView(model, dest);
    Assert.assertEquals(view.visualize(), "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n");

  }

  // tests visualize
  @Test
  public void testVisualize2() throws IOException {
    model = new ImageEditor();
    model.load("./src/images/b.ppm", "visualize.txt");
    this.dest = new StringBuilder();
    view = new TextView(model, dest);
    Assert.assertEquals(view.visualize(), "Color of model.pixel (0,0): 1,2,3\n" +
            "Color of model.pixel (0,1): 9,4,3\n" +
            "Color of model.pixel (1,0): 7,5,3\n" +
            "Color of model.pixel (1,1): 7,4,9\n" +
            "Color of model.pixel (2,0): 1,5,3\n" +
            "Color of model.pixel (2,1): 2,5,9\n" +
            "\n");

  }

  // tests visualize
  @Test
  public void testVisualize3() throws IOException {
    this.model = new ImageEditor();
    this.model.load("./src/images/vertflip.ppm", "visualize.txt");
    this.dest = new StringBuilder();
    this.view = new TextView(model, dest);
    Assert.assertEquals(view.visualize(), "Color of model.pixel (0,0): 1,2,3\n" +
            "Color of model.pixel (0,1): 5,2,6\n" +
            "Color of model.pixel (0,2): 6,8,3\n" +
            "Color of model.pixel (1,0): 4,3,5\n" +
            "Color of model.pixel (1,1): 8,4,2\n" +
            "Color of model.pixel (1,2): 0,2,4\n" +
            "\n");

  }

  // tests toPPM
  @Test
  public void testToPPM() throws IOException {
    this.model = new ImageEditor();
    this.model.load("./src/images/vertflip.ppm", "visualize.txt");
    this.dest = new StringBuilder();
    this.view = new TextView(model, dest);
    Assert.assertEquals(view.toPPM(), "P3\n" +
            "#\n" +
            "2 3 255\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "4\n" +
            "3\n" +
            "5\n" +
            "5\n" +
            "2\n" +
            "6\n" +
            "8\n" +
            "4\n" +
            "2\n" +
            "6\n" +
            "8\n" +
            "3\n" +
            "0\n" +
            "2\n" +
            "4\n" +
            "\n");

  }


}