package controller;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import model.IModel;
import model.ImageEditor;
import view.IView;
import view.TextView;

import static org.junit.Assert.assertEquals;

/**
 * Tests and examples for the controller.
 */
public class TextControllerTest {

  // tests load
  @Test
  public void imageProcessor1() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n\n", a.toString());
  }

  // tests if an oepration works after load
  @Test
  public void imageProcessor2() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example red-component " +
            "example example-red");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,10,10\n" +
            "Color of model.pixel (0,1): 10,10,10\n" +
            "Color of model.pixel (1,0): 70,70,70\n" +
            "Color of model.pixel (1,1): 90,90,90\n" +
            "\n", a.toString());
  }

  // tests if you can load, perform an operation, and then save.
  @Test
  public void imageProcessor3() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example red-component example "
            + "example-red save ./src/images/example.ppm example-red");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,10,10\n" +
            "Color of model.pixel (0,1): 10,10,10\n" +
            "Color of model.pixel (1,0): 70,70,70\n" +
            "Color of model.pixel (1,1): 90,90,90\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,10,10\n" +
            "Color of model.pixel (0,1): 10,10,10\n" +
            "Color of model.pixel (1,0): 70,70,70\n" +
            "Color of model.pixel (1,1): 90,90,90\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to save it, and then carry out an operation.
  @Test
  public void imageProcessor4() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example save " +
            "./src/images/example.ppm "
            + "example red-component example example-red");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,10,10\n" +
            "Color of model.pixel (0,1): 10,10,10\n" +
            "Color of model.pixel (1,0): 70,70,70\n" +
            "Color of model.pixel (1,1): 90,90,90\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to carry out two operations
  @Test
  public void imageProcessor5() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example vertical-flip " +
            "example example-vertical "
            + "blue-component example example-blue");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,50,30\n" +
            "Color of model.pixel (0,1): 10,20,30\n" +
            "Color of model.pixel (1,0): 90,40,30\n" +
            "Color of model.pixel (1,1): 70,50,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 30,30,30\n" +
            "Color of model.pixel (0,1): 30,30,30\n" +
            "Color of model.pixel (1,0): 30,30,30\n" +
            "Color of model.pixel (1,1): 30,30,30\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to carry out a horizontal flip
  @Test
  public void imageProcessor6() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example horizontal-flip example "
            + "example-horizontal");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 70,50,30\n" +
            "Color of model.pixel (0,1): 90,40,30\n" +
            "Color of model.pixel (1,0): 10,20,30\n" +
            "Color of model.pixel (1,1): 10,50,30\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to brighten the image
  @Test
  public void imageProcessor7() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example brighten 10 example " +
            "example-brighten");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 20,30,40\n" +
            "Color of model.pixel (0,1): 20,60,40\n" +
            "Color of model.pixel (1,0): 80,60,40\n" +
            "Color of model.pixel (1,1): 100,50,40\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to darken the image
  @Test
  public void imageProcessor8() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example darken 2 " +
            "example example-darken");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 8,18,28\n" +
            "Color of model.pixel (0,1): 8,48,28\n" +
            "Color of model.pixel (1,0): 68,48,28\n" +
            "Color of model.pixel (1,1): 88,38,28\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to get the green-component of the image
  @Test
  public void imageProcessor9() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example green-component " +
            "example example-green");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 20,20,20\n" +
            "Color of model.pixel (0,1): 50,50,50\n" +
            "Color of model.pixel (1,0): 50,50,50\n" +
            "Color of model.pixel (1,1): 40,40,40\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to get the blue-component of the image
  @Test
  public void imageProcessor10() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example blue-component example " +
            "example-blue");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 30,30,30\n" +
            "Color of model.pixel (0,1): 30,30,30\n" +
            "Color of model.pixel (1,0): 30,30,30\n" +
            "Color of model.pixel (1,1): 30,30,30\n" +
            "\n", a.toString());
  }

  // tests if the same file can be loaded with the same name
  @Test
  public void imageProcessor11() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example "
            + "load ./src/images/img.ppm example2");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n", a.toString());
  }

  // tests if different files can be loaded with the same name
  // overwrite
  @Test
  public void imageProcessor12() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example "
            + "load ./src/images/vertflip.ppm example");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 1,2,3\n" +
            "Color of model.pixel (0,1): 5,2,6\n" +
            "Color of model.pixel (0,2): 6,8,3\n" +
            "Color of model.pixel (1,0): 4,3,5\n" +
            "Color of model.pixel (1,1): 8,4,2\n" +
            "Color of model.pixel (1,2): 0,2,4\n" +
            "\n", a.toString());
  }

  // tests if a file can be load,operated on, saved, then be opened with the old name
  // should be able to load original image again
  @Test
  public void imageProcessor13() throws IOException {
    Readable in = new StringReader("load ./src/images/img.ppm example blue-component example "
            + "example-blue save ./src/images/example-blue.ppm example-blue load " +
            "./src/images/img.ppm ex"
            +
            " example");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 30,30,30\n" +
            "Color of model.pixel (0,1): 30,30,30\n" +
            "Color of model.pixel (1,0): 30,30,30\n" +
            "Color of model.pixel (1,1): 30,30,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 30,30,30\n" +
            "Color of model.pixel (0,1): 30,30,30\n" +
            "Color of model.pixel (1,0): 30,30,30\n" +
            "Color of model.pixel (1,1): 30,30,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n", a.toString());
  }

  @Test
  public void imageProcessor14() throws IOException {
    Readable in = new StringReader("load ./src/images/r1c5.ppm example horizontal-flip example " +
            "ex");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 1,2,3\n" +
            "Color of model.pixel (1,0): 4,5,6\n" +
            "Color of model.pixel (2,0): 7,3,8\n" +
            "Color of model.pixel (3,0): 3,7,4\n" +
            "Color of model.pixel (4,0): 7,3,7\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 7,3,7\n" +
            "Color of model.pixel (1,0): 3,7,4\n" +
            "Color of model.pixel (2,0): 7,3,8\n" +
            "Color of model.pixel (3,0): 4,5,6\n" +
            "Color of model.pixel (4,0): 1,2,3\n" +
            "\n", a.toString());
  }

  @Test
  public void imageProcessor15() throws IOException {
    Readable in = new StringReader("load ./res/colorblock.ppm exam vertical-flip exam ex");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,0\n" +
            "Color of model.pixel (0,1): 255,0,0\n" +
            "Color of model.pixel (1,0): 255,255,255\n" +
            "Color of model.pixel (1,1): 0,255,0\n" +
            "Color of model.pixel (2,0): 0,0,0\n" +
            "Color of model.pixel (2,1): 0,0,255\n" +
            "\n", a.toString());
  }

  // case where user tries to save without loading anything
  @Test
  public void imageProcessor25() throws IOException {
    Readable in = new StringReader("save ./src/images/example-blue example-blue ");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Operation attempt failed. Please try again.\n", a.toString());
  }

  // case where user tries to load something with the wrong file path
  @Test
  public void imageProcessor16() throws IOException {
    Readable in = new StringReader("load ./src/view/img.ppm example");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Operation attempt failed. Please try again.\n", a.toString());
  }

  // case where user tries to load something with the wrong file path
  @Test
  public void imageProcessor17() throws IOException {
    Readable in = new StringReader("load ./src/images/new.ppm example blur example ex-blur");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 18,20,17\n" +
            "Color of model.pixel (0,1): 19,23,17\n" +
            "Color of model.pixel (1,0): 31,23,17\n" +
            "Color of model.pixel (1,1): 33,24,17\n" +
            "\n", a.toString());
  }

  // case where user tries to load something with the wrong file path
  @Test
  public void imageProcessor27() throws IOException {
    Readable in = new StringReader("load ./src/images/new.ppm example blur example ex-blur " +
            "blur ex-blur ex-blurrier");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 18,20,17\n" +
            "Color of model.pixel (0,1): 19,23,17\n" +
            "Color of model.pixel (1,0): 31,23,17\n" +
            "Color of model.pixel (1,1): 33,24,17\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 13,12,10\n" +
            "Color of model.pixel (0,1): 13,13,10\n" +
            "Color of model.pixel (1,0): 15,13,10\n" +
            "Color of model.pixel (1,1): 16,13,10\n" +
            "\n", a.toString());
  }


  // sharpens an image
  @Test
  public void imageProcessor18() throws IOException {
    Readable in = new StringReader("load ./src/images/new.ppm example sharpen example ex-sharpen");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 53,55,53\n" +
            "Color of model.pixel (0,1): 53,78,53\n" +
            "Color of model.pixel (1,0): 98,78,53\n" +
            "Color of model.pixel (1,1): 113,70,53\n" +
            "\n", a.toString());
  }

  //sharpens to the point of clamping
  @Test
  public void imageProcessor28() throws IOException {
    Readable in = new StringReader("load ./src/images/new.ppm example sharpen example " +
            "ex-sharpen sharpen ex-sharpen sharper");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 53,55,53\n" +
            "Color of model.pixel (0,1): 53,78,53\n" +
            "Color of model.pixel (1,0): 98,78,53\n" +
            "Color of model.pixel (1,1): 113,70,53\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 119,112,93\n" +
            "Color of model.pixel (0,1): 119,129,93\n" +
            "Color of model.pixel (1,0): 153,129,93\n" +
            "Color of model.pixel (1,1): 164,123,93\n" +
            "\n", a.toString());
  }

  // tests load
  @Test
  public void imageProcessorPPM1() throws IOException {
    Readable in = new StringReader("load ./res/colorblock.ppm example");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n", a.toString());
  }

  // tests if an oepration works after load
  @Test
  public void imageProcessorPPM2() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example red-component example example-red");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,255,255\n"
            + "Color of model.pixel (0,1): 255,255,255\n"
            + "Color of model.pixel (1,0): 0,0,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,0\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n", a.toString());
  }

  // tests if you can load, perform an operation, and then save.
  @Test
  public void imageProcessorPPM3() throws IOException {
    Readable in = new StringReader("load ./res/colorblock.ppm example red-component example "
            + "example-red save ./src/images/example example-red");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,255\n" +
            "Color of model.pixel (0,1): 255,255,255\n" +
            "Color of model.pixel (1,0): 0,0,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,0\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,255\n" +
            "Color of model.pixel (0,1): 255,255,255\n" +
            "Color of model.pixel (1,0): 0,0,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,0\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to save it, and then carry out an operation.
  @Test
  public void imageProcessorPPM4() throws IOException {
    Readable in = new StringReader("load ./res/colorblock.ppm example save ./src/images/example "
            + "example red-component example example-red");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,255\n" +
            "Color of model.pixel (0,1): 255,255,255\n" +
            "Color of model.pixel (1,0): 0,0,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,0\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to carry out two operations
  @Test
  public void imageProcessorPPM5() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example horizontal-flip example example-horizontal "
                    + "blue-component example-horizontal example-blue");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 0,0,255\n"
            + "Color of model.pixel (0,1): 0,0,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 255,0,0\n"
            + "Color of model.pixel (2,1): 255,255,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,255,255\n"
            + "Color of model.pixel (0,1): 0,0,0\n"
            + "Color of model.pixel (1,0): 0,0,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,0\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to carry out a horizontal flip
  @Test
  public void imageProcessorPPM6() throws IOException {
    Readable in = new StringReader("load ./res/colorblock.ppm example vertical-flip example "
            + "example-vertical");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,0\n" +
            "Color of model.pixel (0,1): 255,0,0\n" +
            "Color of model.pixel (1,0): 255,255,255\n" +
            "Color of model.pixel (1,1): 0,255,0\n" +
            "Color of model.pixel (2,0): 0,0,0\n" +
            "Color of model.pixel (2,1): 0,0,255\n" +
            "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to brighten the image
  @Test
  public void imageProcessorPPM7() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example brighten 20 example example-brighten");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,20,20\n"
            + "Color of model.pixel (0,1): 255,255,20\n"
            + "Color of model.pixel (1,0): 20,255,20\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 20,20,255\n"
            + "Color of model.pixel (2,1): 20,20,20\n"
            + "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to darken the image
  @Test
  public void imageProcessorPPM8() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example darken 2 example example-darken");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 253,0,0\n"
            + "Color of model.pixel (0,1): 253,253,0\n"
            + "Color of model.pixel (1,0): 0,253,0\n"
            + "Color of model.pixel (1,1): 253,253,253\n"
            + "Color of model.pixel (2,0): 0,0,253\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to get the green-component of the image
  @Test
  public void imageProcessorPPM9() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example green-component example example-green");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 0,0,0\n"
            + "Color of model.pixel (0,1): 255,255,255\n"
            + "Color of model.pixel (1,0): 255,255,255\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,0\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n", a.toString());
  }

  // tests if an image loads correctly, then is able to get the blue-component of the image
  @Test
  public void imageProcessorPPM10() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example blue-component example example-blue");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 0,0,0\n"
            + "Color of model.pixel (0,1): 0,0,0\n"
            + "Color of model.pixel (1,0): 0,0,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 255,255,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n", a.toString());
  }

  // tests if the same file can be loaded with the same name
  @Test
  public void imageProcessorPPM11() throws IOException {
    Readable in = new StringReader("load ./res/colorblock.ppm example "
            + "load ./res/colorblock.ppm example2");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n", a.toString());
  }

  // tests if different files can be loaded with the same name
  // overwrite
  @Test
  public void imageProcessorPPM12() throws IOException {
    Readable in = new StringReader("load ./res/colorblock.ppm example "
            + "load ./res/colorblock.ppm example");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n", a.toString());
  }

  // tests if a file can be load,operated on, saved, then be opened with the old name
  // should be able to load original image again
  @Test
  public void imageProcessorPPM13() throws IOException {
    Readable in = new StringReader("load ./res/colorblock.ppm example blue-component example "
            + "example-blue save ./res/colorblock-blue.ppm example-blue load " +
            "./res/colorblock.ppm example");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 0,0,0\n" +
            "Color of model.pixel (0,1): 0,0,0\n" +
            "Color of model.pixel (1,0): 0,0,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 255,255,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 0,0,0\n" +
            "Color of model.pixel (0,1): 0,0,0\n" +
            "Color of model.pixel (1,0): 0,0,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 255,255,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n", a.toString());
  }


  // a flip and a greyscale operation
  @Test
  public void imageProcessorPPM14() throws IOException {
    Readable in = new StringReader("load ./res/colorblock.ppm example blue-component example "
            + "example-blue horizontal-flip example-blue example-hflip-blue");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,0,0\n"
            + "Color of model.pixel (0,1): 255,255,0\n"
            + "Color of model.pixel (1,0): 0,255,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 0,0,0\n"
            + "Color of model.pixel (0,1): 0,0,0\n"
            + "Color of model.pixel (1,0): 0,0,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 255,255,255\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n"
            + "Successfully completed operation!\n"
            + "Color of model.pixel (0,0): 255,255,255\n"
            + "Color of model.pixel (0,1): 0,0,0\n"
            + "Color of model.pixel (1,0): 0,0,0\n"
            + "Color of model.pixel (1,1): 255,255,255\n"
            + "Color of model.pixel (2,0): 0,0,0\n"
            + "Color of model.pixel (2,1): 0,0,0\n"
            + "\n", a.toString());
  }

  // blurs an image once
  @Test
  public void imageProcessorPPM100() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example blur example example-blur");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 112,80,16\n" +
            "Color of model.pixel (0,1): 128,112,32\n" +
            "Color of model.pixel (1,0): 80,112,64\n" +
            "Color of model.pixel (1,1): 112,128,80\n" +
            "Color of model.pixel (2,0): 16,48,80\n" +
            "Color of model.pixel (2,1): 32,48,64\n" +
            "\n", a.toString());
  }

  // blurs an image twice
  @Test
  public void imageProcessorPPM1001() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example blur example example-blur blur example-blur " +
                    "ex-blurrier");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 112,80,16\n" +
            "Color of model.pixel (0,1): 128,112,32\n" +
            "Color of model.pixel (1,0): 80,112,64\n" +
            "Color of model.pixel (1,1): 112,128,80\n" +
            "Color of model.pixel (2,0): 16,48,80\n" +
            "Color of model.pixel (2,1): 32,48,64\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 61,56,21\n" +
            "Color of model.pixel (0,1): 65,61,24\n" +
            "Color of model.pixel (1,0): 60,70,44\n" +
            "Color of model.pixel (1,1): 66,74,46\n" +
            "Color of model.pixel (2,0): 25,40,41\n" +
            "Color of model.pixel (2,1): 29,41,40\n" +
            "\n", a.toString());
  }

  // sharpens an image twice
  @Test
  public void imageProcessorPPM111() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example sharpen example example-sharp sharpen " +
                    "example-sharp ex-sharper");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,191,32\n" +
            "Color of model.pixel (0,1): 255,255,32\n" +
            "Color of model.pixel (1,0): 191,255,128\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,96,255\n" +
            "Color of model.pixel (2,1): 0,96,128\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,88\n" +
            "Color of model.pixel (0,1): 255,255,88\n" +
            "Color of model.pixel (1,0): 255,255,255\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 48,192,255\n" +
            "Color of model.pixel (2,1): 48,192,255\n" +
            "\n", a.toString());
  }

  // sharpens an image once
  @Test
  public void imageProcessorPPM1111() throws IOException {
    Readable in = new StringReader(
            "load ./res/colorblock.ppm example sharpen example example-sharp");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,0,0\n" +
            "Color of model.pixel (0,1): 255,255,0\n" +
            "Color of model.pixel (1,0): 0,255,0\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,0,255\n" +
            "Color of model.pixel (2,1): 0,0,0\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,191,32\n" +
            "Color of model.pixel (0,1): 255,255,32\n" +
            "Color of model.pixel (1,0): 191,255,128\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (2,0): 0,96,255\n" +
            "Color of model.pixel (2,1): 0,96,128\n" +
            "\n", a.toString());
  }

  // sepia a ppm
  @Test
  public void imageProcessorPPM11111() throws IOException {
    Readable in = new StringReader(
            "load ./src/images/img.ppm example sepia example example-sepia");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 25,22,17\n" +
            "Color of model.pixel (0,1): 48,43,33\n" +
            "Color of model.pixel (1,0): 72,64,50\n" +
            "Color of model.pixel (1,1): 72,64,50\n" +
            "\n", a.toString());
  }

  // greyscale a ppm
  @Test
  public void imageProcessorPPM111111() throws IOException {
    Readable in = new StringReader(
            "load ./src/images/img.ppm example greyscale example example-greyscale");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 10,20,30\n" +
            "Color of model.pixel (0,1): 10,50,30\n" +
            "Color of model.pixel (1,0): 70,50,30\n" +
            "Color of model.pixel (1,1): 90,40,30\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 19,19,19\n" +
            "Color of model.pixel (0,1): 40,40,40\n" +
            "Color of model.pixel (1,0): 53,53,53\n" +
            "Color of model.pixel (1,1): 50,50,50\n" +
            "\n", a.toString());
  }

  // load and save png - TEST PASSES BUT FILE IS TOO LARGE TO INSERT INTO ASSERTEQUALS
  //  @Test
  //  public void imageProcessor20() throws IOException {
  //    Readable in = new StringReader("load ./res/notepad.load.png ch save
  //    ./res/notepad.save.png ch");
  //    IModel model = new ImageEditor();
  //    Appendable a = new StringBuilder();
  //    IView view = new TextView(model, a);
  //    IController controller = new TextController(model, view, in);
  //    controller.imageProcessor();
  //
  //    assertEquals("Successfully completed operation!\n" +
  //            "Color of model.pixel (0,0): 0,0,0\n" +
  //            "Color of model.pixel (0,1): 0,0,0\n" +
  //            "Color of model.pixel (0,2): 0,0,0\n" +
  //            "Color of model.pixel (0,3): 0,0,0\n" +
  //            "Color of model.pixel (0,4): 0,0,0\n" +
  //            "Color of model.pixel (0,5): 0,0,0\n" +
  //            "Color of model.pixel (0,6): 0,0,0\n" +
  //            "Color of model.pixel (0,7): 0,0,0\n" +
  //            "Color of model.pixel (0,8): 0,0,0\n" +
  //            "Color of model.pixel (0,9): 0,0,0\n" +
  //            "Color of model.pixel (0,10): 0,0,0\n" +
  //            "Color of model.pixel (0,11): 0,0,0\n" +
  //            "Color of model.pixel (0,12): 0,0,0\n" +
  //            "Color of model.pixel (0,13): 0,0,0\n" +
  //            "Color of model.pixel (0,14): 0,0,0\n" +
  //            "Color of model.pixel (0,15): 0,0,0\n" +
  //            "Color of model.pixel (0,16): 0,0,0", a.toString());
  //  }


  // load and save bmp
  @Test
  public void imageProcessor2011() throws IOException {
    Readable in = new StringReader("load ./res/NERD.bmp d save ./res/NERD.ppm d");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 0,104,207\n" +
            "Color of model.pixel (0,1): 0,115,230\n" +
            "Color of model.pixel (0,2): 0,115,230\n" +
            "Color of model.pixel (0,3): 20,113,184\n" +
            "Color of model.pixel (0,4): 0,110,219\n" +
            "Color of model.pixel (0,5): 0,115,230\n" +
            "Color of model.pixel (0,6): 0,115,230\n" +
            "Color of model.pixel (0,7): 0,115,230\n" +
            "Color of model.pixel (0,8): 0,115,230\n" +
            "Color of model.pixel (0,9): 0,104,207\n" +
            "Color of model.pixel (1,0): 0,115,230\n" +
            "Color of model.pixel (1,1): 0,128,255\n" +
            "Color of model.pixel (1,2): 0,128,255\n" +
            "Color of model.pixel (1,3): 158,193,69\n" +
            "Color of model.pixel (1,4): 94,150,129\n" +
            "Color of model.pixel (1,5): 69,142,214\n" +
            "Color of model.pixel (1,6): 54,136,218\n" +
            "Color of model.pixel (1,7): 5,125,244\n" +
            "Color of model.pixel (1,8): 0,128,255\n" +
            "Color of model.pixel (1,9): 0,115,230\n" +
            "Color of model.pixel (2,0): 0,115,230\n" +
            "Color of model.pixel (2,1): 3,127,247\n" +
            "Color of model.pixel (2,2): 94,160,130\n" +
            "Color of model.pixel (2,3): 196,185,100\n" +
            "Color of model.pixel (2,4): 153,197,180\n" +
            "Color of model.pixel (2,5): 217,205,182\n" +
            "Color of model.pixel (2,6): 255,226,198\n" +
            "Color of model.pixel (2,7): 224,207,190\n" +
            "Color of model.pixel (2,8): 105,105,153\n" +
            "Color of model.pixel (2,9): 84,61,122\n" +
            "Color of model.pixel (3,0): 0,115,230\n" +
            "Color of model.pixel (3,1): 89,160,140\n" +
            "Color of model.pixel (3,2): 229,218,81\n" +
            "Color of model.pixel (3,3): 112,217,204\n" +
            "Color of model.pixel (3,4): 102,230,230\n" +
            "Color of model.pixel (3,5): 224,231,230\n" +
            "Color of model.pixel (3,6): 230,211,186\n" +
            "Color of model.pixel (3,7): 255,226,198\n" +
            "Color of model.pixel (3,8): 245,210,184\n" +
            "Color of model.pixel (3,9): 214,18,16\n" +
            "Color of model.pixel (4,0): 0,115,230\n" +
            "Color of model.pixel (4,1): 84,155,140\n" +
            "Color of model.pixel (4,2): 227,204,156\n" +
            "Color of model.pixel (4,3): 194,198,183\n" +
            "Color of model.pixel (4,4): 235,242,242\n" +
            "Color of model.pixel (4,5): 82,216,213\n" +
            "Color of model.pixel (4,6): 242,217,191\n" +
            "Color of model.pixel (4,7): 255,226,198\n" +
            "Color of model.pixel (4,8): 255,226,198\n" +
            "Color of model.pixel (4,9): 204,90,79\n" +
            "Color of model.pixel (5,0): 0,115,230\n" +
            "Color of model.pixel (5,1): 43,136,184\n" +
            "Color of model.pixel (5,2): 230,204,172\n" +
            "Color of model.pixel (5,3): 209,216,193\n" +
            "Color of model.pixel (5,4): 61,188,182\n" +
            "Color of model.pixel (5,5): 212,198,183\n" +
            "Color of model.pixel (5,6): 224,199,174\n" +
            "Color of model.pixel (5,7): 247,219,192\n" +
            "Color of model.pixel (5,8): 255,226,198\n" +
            "Color of model.pixel (5,9): 204,106,93\n" +
            "Color of model.pixel (6,0): 0,115,230\n" +
            "Color of model.pixel (6,1): 51,141,179\n" +
            "Color of model.pixel (6,2): 230,212,121\n" +
            "Color of model.pixel (6,3): 82,212,204\n" +
            "Color of model.pixel (6,4): 189,235,235\n" +
            "Color of model.pixel (6,5): 92,230,230\n" +
            "Color of model.pixel (6,6): 212,200,177\n" +
            "Color of model.pixel (6,7): 255,226,198\n" +
            "Color of model.pixel (6,8): 255,226,198\n" +
            "Color of model.pixel (6,9): 204,47,42\n" +
            "Color of model.pixel (7,0): 0,115,230\n" +
            "Color of model.pixel (7,1): 8,124,232\n" +
            "Color of model.pixel (7,2): 158,182,71\n" +
            "Color of model.pixel (7,3): 201,190,162\n" +
            "Color of model.pixel (7,4): 102,205,204\n" +
            "Color of model.pixel (7,5): 74,219,210\n" +
            "Color of model.pixel (7,6): 250,221,194\n" +
            "Color of model.pixel (7,7): 255,226,198\n" +
            "Color of model.pixel (7,8): 156,156,173\n" +
            "Color of model.pixel (7,9): 115,46,92\n" +
            "Color of model.pixel (8,0): 0,115,230\n" +
            "Color of model.pixel (8,1): 0,128,255\n" +
            "Color of model.pixel (8,2): 0,128,255\n" +
            "Color of model.pixel (8,3): 138,168,76\n" +
            "Color of model.pixel (8,4): 110,154,197\n" +
            "Color of model.pixel (8,5): 171,181,191\n" +
            "Color of model.pixel (8,6): 156,175,195\n" +
            "Color of model.pixel (8,7): 77,145,212\n" +
            "Color of model.pixel (8,8): 0,127,252\n" +
            "Color of model.pixel (8,9): 0,115,230\n" +
            "Color of model.pixel (9,0): 0,104,207\n" +
            "Color of model.pixel (9,1): 0,115,230\n" +
            "Color of model.pixel (9,2): 0,115,230\n" +
            "Color of model.pixel (9,3): 8,109,201\n" +
            "Color of model.pixel (9,4): 0,115,230\n" +
            "Color of model.pixel (9,5): 0,115,230\n" +
            "Color of model.pixel (9,6): 0,115,230\n" +
            "Color of model.pixel (9,7): 0,115,230\n" +
            "Color of model.pixel (9,8): 0,115,230\n" +
            "Color of model.pixel (9,9): 0,104,207\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 0,104,207\n" +
            "Color of model.pixel (0,1): 0,115,230\n" +
            "Color of model.pixel (0,2): 0,115,230\n" +
            "Color of model.pixel (0,3): 20,113,184\n" +
            "Color of model.pixel (0,4): 0,110,219\n" +
            "Color of model.pixel (0,5): 0,115,230\n" +
            "Color of model.pixel (0,6): 0,115,230\n" +
            "Color of model.pixel (0,7): 0,115,230\n" +
            "Color of model.pixel (0,8): 0,115,230\n" +
            "Color of model.pixel (0,9): 0,104,207\n" +
            "Color of model.pixel (1,0): 0,115,230\n" +
            "Color of model.pixel (1,1): 0,128,255\n" +
            "Color of model.pixel (1,2): 0,128,255\n" +
            "Color of model.pixel (1,3): 158,193,69\n" +
            "Color of model.pixel (1,4): 94,150,129\n" +
            "Color of model.pixel (1,5): 69,142,214\n" +
            "Color of model.pixel (1,6): 54,136,218\n" +
            "Color of model.pixel (1,7): 5,125,244\n" +
            "Color of model.pixel (1,8): 0,128,255\n" +
            "Color of model.pixel (1,9): 0,115,230\n" +
            "Color of model.pixel (2,0): 0,115,230\n" +
            "Color of model.pixel (2,1): 3,127,247\n" +
            "Color of model.pixel (2,2): 94,160,130\n" +
            "Color of model.pixel (2,3): 196,185,100\n" +
            "Color of model.pixel (2,4): 153,197,180\n" +
            "Color of model.pixel (2,5): 217,205,182\n" +
            "Color of model.pixel (2,6): 255,226,198\n" +
            "Color of model.pixel (2,7): 224,207,190\n" +
            "Color of model.pixel (2,8): 105,105,153\n" +
            "Color of model.pixel (2,9): 84,61,122\n" +
            "Color of model.pixel (3,0): 0,115,230\n" +
            "Color of model.pixel (3,1): 89,160,140\n" +
            "Color of model.pixel (3,2): 229,218,81\n" +
            "Color of model.pixel (3,3): 112,217,204\n" +
            "Color of model.pixel (3,4): 102,230,230\n" +
            "Color of model.pixel (3,5): 224,231,230\n" +
            "Color of model.pixel (3,6): 230,211,186\n" +
            "Color of model.pixel (3,7): 255,226,198\n" +
            "Color of model.pixel (3,8): 245,210,184\n" +
            "Color of model.pixel (3,9): 214,18,16\n" +
            "Color of model.pixel (4,0): 0,115,230\n" +
            "Color of model.pixel (4,1): 84,155,140\n" +
            "Color of model.pixel (4,2): 227,204,156\n" +
            "Color of model.pixel (4,3): 194,198,183\n" +
            "Color of model.pixel (4,4): 235,242,242\n" +
            "Color of model.pixel (4,5): 82,216,213\n" +
            "Color of model.pixel (4,6): 242,217,191\n" +
            "Color of model.pixel (4,7): 255,226,198\n" +
            "Color of model.pixel (4,8): 255,226,198\n" +
            "Color of model.pixel (4,9): 204,90,79\n" +
            "Color of model.pixel (5,0): 0,115,230\n" +
            "Color of model.pixel (5,1): 43,136,184\n" +
            "Color of model.pixel (5,2): 230,204,172\n" +
            "Color of model.pixel (5,3): 209,216,193\n" +
            "Color of model.pixel (5,4): 61,188,182\n" +
            "Color of model.pixel (5,5): 212,198,183\n" +
            "Color of model.pixel (5,6): 224,199,174\n" +
            "Color of model.pixel (5,7): 247,219,192\n" +
            "Color of model.pixel (5,8): 255,226,198\n" +
            "Color of model.pixel (5,9): 204,106,93\n" +
            "Color of model.pixel (6,0): 0,115,230\n" +
            "Color of model.pixel (6,1): 51,141,179\n" +
            "Color of model.pixel (6,2): 230,212,121\n" +
            "Color of model.pixel (6,3): 82,212,204\n" +
            "Color of model.pixel (6,4): 189,235,235\n" +
            "Color of model.pixel (6,5): 92,230,230\n" +
            "Color of model.pixel (6,6): 212,200,177\n" +
            "Color of model.pixel (6,7): 255,226,198\n" +
            "Color of model.pixel (6,8): 255,226,198\n" +
            "Color of model.pixel (6,9): 204,47,42\n" +
            "Color of model.pixel (7,0): 0,115,230\n" +
            "Color of model.pixel (7,1): 8,124,232\n" +
            "Color of model.pixel (7,2): 158,182,71\n" +
            "Color of model.pixel (7,3): 201,190,162\n" +
            "Color of model.pixel (7,4): 102,205,204\n" +
            "Color of model.pixel (7,5): 74,219,210\n" +
            "Color of model.pixel (7,6): 250,221,194\n" +
            "Color of model.pixel (7,7): 255,226,198\n" +
            "Color of model.pixel (7,8): 156,156,173\n" +
            "Color of model.pixel (7,9): 115,46,92\n" +
            "Color of model.pixel (8,0): 0,115,230\n" +
            "Color of model.pixel (8,1): 0,128,255\n" +
            "Color of model.pixel (8,2): 0,128,255\n" +
            "Color of model.pixel (8,3): 138,168,76\n" +
            "Color of model.pixel (8,4): 110,154,197\n" +
            "Color of model.pixel (8,5): 171,181,191\n" +
            "Color of model.pixel (8,6): 156,175,195\n" +
            "Color of model.pixel (8,7): 77,145,212\n" +
            "Color of model.pixel (8,8): 0,127,252\n" +
            "Color of model.pixel (8,9): 0,115,230\n" +
            "Color of model.pixel (9,0): 0,104,207\n" +
            "Color of model.pixel (9,1): 0,115,230\n" +
            "Color of model.pixel (9,2): 0,115,230\n" +
            "Color of model.pixel (9,3): 8,109,201\n" +
            "Color of model.pixel (9,4): 0,115,230\n" +
            "Color of model.pixel (9,5): 0,115,230\n" +
            "Color of model.pixel (9,6): 0,115,230\n" +
            "Color of model.pixel (9,7): 0,115,230\n" +
            "Color of model.pixel (9,8): 0,115,230\n" +
            "Color of model.pixel (9,9): 0,104,207\n" +
            "\n", a.toString());
  }


  // jpg to ppm
  @Test
  public void imageProcessorPPM1121111() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this save ./res/googleSMALL.ppm this");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n", a.toString());
  }

  // ppm to jpg
  @Test
  public void imageProcessorPPM1111211() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.ppm example save ./res/googleSMALL.jpg example ");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n", a.toString());
  }

  // blur on jpg
  @Test
  public void imageProcessorPPM1121113() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this blur this this-blur");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 140,142,134\n" +
            "Color of model.pixel (0,1): 184,187,177\n" +
            "Color of model.pixel (0,2): 182,185,174\n" +
            "Color of model.pixel (0,3): 179,182,172\n" +
            "Color of model.pixel (0,4): 172,175,165\n" +
            "Color of model.pixel (0,5): 160,163,153\n" +
            "Color of model.pixel (0,6): 115,117,109\n" +
            "Color of model.pixel (1,0): 186,188,179\n" +
            "Color of model.pixel (1,1): 235,239,226\n" +
            "Color of model.pixel (1,2): 224,227,214\n" +
            "Color of model.pixel (1,3): 223,227,214\n" +
            "Color of model.pixel (1,4): 219,223,209\n" +
            "Color of model.pixel (1,5): 217,220,207\n" +
            "Color of model.pixel (1,6): 166,168,159\n" +
            "Color of model.pixel (2,0): 179,181,173\n" +
            "Color of model.pixel (2,1): 212,215,204\n" +
            "Color of model.pixel (2,2): 195,198,187\n" +
            "Color of model.pixel (2,3): 203,206,195\n" +
            "Color of model.pixel (2,4): 200,203,192\n" +
            "Color of model.pixel (2,5): 201,204,193\n" +
            "Color of model.pixel (2,6): 161,163,155\n" +
            "Color of model.pixel (3,0): 168,170,164\n" +
            "Color of model.pixel (3,1): 200,203,194\n" +
            "Color of model.pixel (3,2): 187,190,181\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 190,193,184\n" +
            "Color of model.pixel (3,5): 189,192,183\n" +
            "Color of model.pixel (3,6): 153,155,148\n" +
            "Color of model.pixel (4,0): 165,167,162\n" +
            "Color of model.pixel (4,1): 213,215,208\n" +
            "Color of model.pixel (4,2): 200,203,196\n" +
            "Color of model.pixel (4,3): 185,187,180\n" +
            "Color of model.pixel (4,4): 187,189,182\n" +
            "Color of model.pixel (4,5): 202,205,198\n" +
            "Color of model.pixel (4,6): 162,164,159\n" +
            "Color of model.pixel (5,0): 173,175,171\n" +
            "Color of model.pixel (5,1): 233,235,231\n" +
            "Color of model.pixel (5,2): 219,222,217\n" +
            "Color of model.pixel (5,3): 195,197,193\n" +
            "Color of model.pixel (5,4): 202,204,200\n" +
            "Color of model.pixel (5,5): 223,225,220\n" +
            "Color of model.pixel (5,6): 168,170,167\n" +
            "Color of model.pixel (6,0): 134,135,134\n" +
            "Color of model.pixel (6,1): 182,183,181\n" +
            "Color of model.pixel (6,2): 175,177,175\n" +
            "Color of model.pixel (6,3): 164,165,163\n" +
            "Color of model.pixel (6,4): 170,171,169\n" +
            "Color of model.pixel (6,5): 174,175,174\n" +
            "Color of model.pixel (6,6): 122,123,122\n" +
            "\n", a.toString());


  }

  // sharpen on jpg
  @Test
  public void imageProcessorPPM1121114() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this sharpen this this-sharpen");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,255\n" +
            "Color of model.pixel (0,1): 255,255,255\n" +
            "Color of model.pixel (0,2): 255,255,255\n" +
            "Color of model.pixel (0,3): 255,255,255\n" +
            "Color of model.pixel (0,4): 255,255,255\n" +
            "Color of model.pixel (0,5): 255,255,255\n" +
            "Color of model.pixel (0,6): 218,222,206\n" +
            "Color of model.pixel (1,0): 255,255,255\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (1,2): 255,255,255\n" +
            "Color of model.pixel (1,3): 255,255,255\n" +
            "Color of model.pixel (1,4): 255,255,255\n" +
            "Color of model.pixel (1,5): 255,255,255\n" +
            "Color of model.pixel (1,6): 255,255,255\n" +
            "Color of model.pixel (2,0): 255,255,255\n" +
            "Color of model.pixel (2,1): 255,255,255\n" +
            "Color of model.pixel (2,2): 114,117,104\n" +
            "Color of model.pixel (2,3): 224,227,214\n" +
            "Color of model.pixel (2,4): 159,162,150\n" +
            "Color of model.pixel (2,5): 255,255,255\n" +
            "Color of model.pixel (2,6): 245,248,235\n" +
            "Color of model.pixel (3,0): 255,255,255\n" +
            "Color of model.pixel (3,1): 255,255,255\n" +
            "Color of model.pixel (3,2): 131,134,125\n" +
            "Color of model.pixel (3,3): 147,150,141\n" +
            "Color of model.pixel (3,4): 161,165,156\n" +
            "Color of model.pixel (3,5): 249,254,239\n" +
            "Color of model.pixel (3,6): 223,226,216\n" +
            "Color of model.pixel (4,0): 241,244,236\n" +
            "Color of model.pixel (4,1): 255,255,255\n" +
            "Color of model.pixel (4,2): 171,174,165\n" +
            "Color of model.pixel (4,3): 133,136,127\n" +
            "Color of model.pixel (4,4): 129,133,124\n" +
            "Color of model.pixel (4,5): 255,255,255\n" +
            "Color of model.pixel (4,6): 255,255,251\n" +
            "Color of model.pixel (5,0): 255,255,255\n" +
            "Color of model.pixel (5,1): 255,255,255\n" +
            "Color of model.pixel (5,2): 255,255,255\n" +
            "Color of model.pixel (5,3): 255,255,255\n" +
            "Color of model.pixel (5,4): 255,255,255\n" +
            "Color of model.pixel (5,5): 255,255,255\n" +
            "Color of model.pixel (5,6): 255,255,255\n" +
            "Color of model.pixel (6,0): 255,255,255\n" +
            "Color of model.pixel (6,1): 255,255,255\n" +
            "Color of model.pixel (6,2): 255,255,255\n" +
            "Color of model.pixel (6,3): 254,255,255\n" +
            "Color of model.pixel (6,4): 255,255,255\n" +
            "Color of model.pixel (6,5): 255,255,255\n" +
            "Color of model.pixel (6,6): 240,241,241\n" +
            "\n", a.toString());


  }

  // sharpen and blur on jpg
  @Test
  public void imageProcessorPPM1121115() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this sharpen this this-sharpen blur this-sharpen "
                    + "this-sharpen-blur");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,255\n" +
            "Color of model.pixel (0,1): 255,255,255\n" +
            "Color of model.pixel (0,2): 255,255,255\n" +
            "Color of model.pixel (0,3): 255,255,255\n" +
            "Color of model.pixel (0,4): 255,255,255\n" +
            "Color of model.pixel (0,5): 255,255,255\n" +
            "Color of model.pixel (0,6): 218,222,206\n" +
            "Color of model.pixel (1,0): 255,255,255\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (1,2): 255,255,255\n" +
            "Color of model.pixel (1,3): 255,255,255\n" +
            "Color of model.pixel (1,4): 255,255,255\n" +
            "Color of model.pixel (1,5): 255,255,255\n" +
            "Color of model.pixel (1,6): 255,255,255\n" +
            "Color of model.pixel (2,0): 255,255,255\n" +
            "Color of model.pixel (2,1): 255,255,255\n" +
            "Color of model.pixel (2,2): 114,117,104\n" +
            "Color of model.pixel (2,3): 224,227,214\n" +
            "Color of model.pixel (2,4): 159,162,150\n" +
            "Color of model.pixel (2,5): 255,255,255\n" +
            "Color of model.pixel (2,6): 245,248,235\n" +
            "Color of model.pixel (3,0): 255,255,255\n" +
            "Color of model.pixel (3,1): 255,255,255\n" +
            "Color of model.pixel (3,2): 131,134,125\n" +
            "Color of model.pixel (3,3): 147,150,141\n" +
            "Color of model.pixel (3,4): 161,165,156\n" +
            "Color of model.pixel (3,5): 249,254,239\n" +
            "Color of model.pixel (3,6): 223,226,216\n" +
            "Color of model.pixel (4,0): 241,244,236\n" +
            "Color of model.pixel (4,1): 255,255,255\n" +
            "Color of model.pixel (4,2): 171,174,165\n" +
            "Color of model.pixel (4,3): 133,136,127\n" +
            "Color of model.pixel (4,4): 129,133,124\n" +
            "Color of model.pixel (4,5): 255,255,255\n" +
            "Color of model.pixel (4,6): 255,255,251\n" +
            "Color of model.pixel (5,0): 255,255,255\n" +
            "Color of model.pixel (5,1): 255,255,255\n" +
            "Color of model.pixel (5,2): 255,255,255\n" +
            "Color of model.pixel (5,3): 255,255,255\n" +
            "Color of model.pixel (5,4): 255,255,255\n" +
            "Color of model.pixel (5,5): 255,255,255\n" +
            "Color of model.pixel (5,6): 255,255,255\n" +
            "Color of model.pixel (6,0): 255,255,255\n" +
            "Color of model.pixel (6,1): 255,255,255\n" +
            "Color of model.pixel (6,2): 255,255,255\n" +
            "Color of model.pixel (6,3): 254,255,255\n" +
            "Color of model.pixel (6,4): 255,255,255\n" +
            "Color of model.pixel (6,5): 255,255,255\n" +
            "Color of model.pixel (6,6): 240,241,241\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 143,143,143\n" +
            "Color of model.pixel (0,1): 191,191,191\n" +
            "Color of model.pixel (0,2): 191,191,191\n" +
            "Color of model.pixel (0,3): 191,191,191\n" +
            "Color of model.pixel (0,4): 191,191,191\n" +
            "Color of model.pixel (0,5): 187,187,185\n" +
            "Color of model.pixel (0,6): 134,135,131\n" +
            "Color of model.pixel (1,0): 191,191,191\n" +
            "Color of model.pixel (1,1): 246,246,246\n" +
            "Color of model.pixel (1,2): 235,236,234\n" +
            "Color of model.pixel (1,3): 236,237,234\n" +
            "Color of model.pixel (1,4): 241,242,239\n" +
            "Color of model.pixel (1,5): 246,247,244\n" +
            "Color of model.pixel (1,6): 185,186,183\n" +
            "Color of model.pixel (2,0): 191,191,191\n" +
            "Color of model.pixel (2,1): 230,230,228\n" +
            "Color of model.pixel (2,2): 194,195,189\n" +
            "Color of model.pixel (2,3): 191,193,184\n" +
            "Color of model.pixel (2,4): 208,210,203\n" +
            "Color of model.pixel (2,5): 233,235,229\n" +
            "Color of model.pixel (2,6): 184,186,180\n" +
            "Color of model.pixel (3,0): 190,190,189\n" +
            "Color of model.pixel (3,1): 225,226,223\n" +
            "Color of model.pixel (3,2): 173,175,168\n" +
            "Color of model.pixel (3,3): 154,157,147\n" +
            "Color of model.pixel (3,4): 180,183,174\n" +
            "Color of model.pixel (3,5): 223,226,218\n" +
            "Color of model.pixel (3,6): 181,183,177\n" +
            "Color of model.pixel (4,0): 188,189,187\n" +
            "Color of model.pixel (4,1): 235,236,233\n" +
            "Color of model.pixel (4,2): 197,198,193\n" +
            "Color of model.pixel (4,3): 171,174,167\n" +
            "Color of model.pixel (4,4): 189,192,186\n" +
            "Color of model.pixel (4,5): 231,232,228\n" +
            "Color of model.pixel (4,6): 187,188,184\n" +
            "Color of model.pixel (5,0): 190,190,189\n" +
            "Color of model.pixel (5,1): 249,249,248\n" +
            "Color of model.pixel (5,2): 237,237,236\n" +
            "Color of model.pixel (5,3): 227,227,225\n" +
            "Color of model.pixel (5,4): 232,232,231\n" +
            "Color of model.pixel (5,5): 246,247,246\n" +
            "Color of model.pixel (5,6): 189,190,189\n" +
            "Color of model.pixel (6,0): 143,143,143\n" +
            "Color of model.pixel (6,1): 191,191,191\n" +
            "Color of model.pixel (6,2): 191,191,191\n" +
            "Color of model.pixel (6,3): 191,191,191\n" +
            "Color of model.pixel (6,4): 191,191,191\n" +
            "Color of model.pixel (6,5): 189,190,190\n" +
            "Color of model.pixel (6,6): 140,140,140\n" +
            "\n", a.toString());


  }

  // greyscale on jpg
  @Test
  public void imageProcessorPPM1121116() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this greyscale this this-greyscale");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 251,251,251\n" +
            "Color of model.pixel (0,1): 245,245,245\n" +
            "Color of model.pixel (0,2): 248,248,248\n" +
            "Color of model.pixel (0,3): 248,248,248\n" +
            "Color of model.pixel (0,4): 239,239,239\n" +
            "Color of model.pixel (0,5): 199,199,199\n" +
            "Color of model.pixel (0,6): 178,178,178\n" +
            "Color of model.pixel (1,0): 253,253,253\n" +
            "Color of model.pixel (1,1): 252,252,252\n" +
            "Color of model.pixel (1,2): 233,233,233\n" +
            "Color of model.pixel (1,3): 232,232,232\n" +
            "Color of model.pixel (1,4): 231,231,231\n" +
            "Color of model.pixel (1,5): 234,234,234\n" +
            "Color of model.pixel (1,6): 254,254,254\n" +
            "Color of model.pixel (2,0): 252,252,252\n" +
            "Color of model.pixel (2,1): 223,223,223\n" +
            "Color of model.pixel (2,2): 127,127,127\n" +
            "Color of model.pixel (2,3): 244,244,244\n" +
            "Color of model.pixel (2,4): 151,151,151\n" +
            "Color of model.pixel (2,5): 206,206,206\n" +
            "Color of model.pixel (2,6): 213,213,213\n" +
            "Color of model.pixel (3,0): 254,254,254\n" +
            "Color of model.pixel (3,1): 167,167,167\n" +
            "Color of model.pixel (3,2): 198,198,198\n" +
            "Color of model.pixel (3,3): 195,195,195\n" +
            "Color of model.pixel (3,4): 233,233,233\n" +
            "Color of model.pixel (3,5): 138,138,138\n" +
            "Color of model.pixel (3,6): 225,225,225\n" +
            "Color of model.pixel (4,0): 217,217,217\n" +
            "Color of model.pixel (4,1): 197,197,197\n" +
            "Color of model.pixel (4,2): 224,224,224\n" +
            "Color of model.pixel (4,3): 148,148,148\n" +
            "Color of model.pixel (4,4): 187,187,187\n" +
            "Color of model.pixel (4,5): 192,192,192\n" +
            "Color of model.pixel (4,6): 233,233,233\n" +
            "Color of model.pixel (5,0): 236,236,236\n" +
            "Color of model.pixel (5,1): 246,246,246\n" +
            "Color of model.pixel (5,2): 243,243,243\n" +
            "Color of model.pixel (5,3): 156,156,156\n" +
            "Color of model.pixel (5,4): 190,190,190\n" +
            "Color of model.pixel (5,5): 250,250,250\n" +
            "Color of model.pixel (5,6): 230,230,230\n" +
            "Color of model.pixel (6,0): 234,234,234\n" +
            "Color of model.pixel (6,1): 251,251,251\n" +
            "Color of model.pixel (6,2): 242,242,242\n" +
            "Color of model.pixel (6,3): 231,231,231\n" +
            "Color of model.pixel (6,4): 243,243,243\n" +
            "Color of model.pixel (6,5): 255,255,255\n" +
            "Color of model.pixel (6,6): 188,188,188\n" +
            "\n", a.toString());


  }

  // greyscale and sepia together on jpg
  @Test
  public void imageProcessorPPM1121117() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this greyscale this this-greyscale sepia this-greyscale "
                    + "this-greyscale-sepia");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 251,251,251\n" +
            "Color of model.pixel (0,1): 245,245,245\n" +
            "Color of model.pixel (0,2): 248,248,248\n" +
            "Color of model.pixel (0,3): 248,248,248\n" +
            "Color of model.pixel (0,4): 239,239,239\n" +
            "Color of model.pixel (0,5): 199,199,199\n" +
            "Color of model.pixel (0,6): 178,178,178\n" +
            "Color of model.pixel (1,0): 253,253,253\n" +
            "Color of model.pixel (1,1): 252,252,252\n" +
            "Color of model.pixel (1,2): 233,233,233\n" +
            "Color of model.pixel (1,3): 232,232,232\n" +
            "Color of model.pixel (1,4): 231,231,231\n" +
            "Color of model.pixel (1,5): 234,234,234\n" +
            "Color of model.pixel (1,6): 254,254,254\n" +
            "Color of model.pixel (2,0): 252,252,252\n" +
            "Color of model.pixel (2,1): 223,223,223\n" +
            "Color of model.pixel (2,2): 127,127,127\n" +
            "Color of model.pixel (2,3): 244,244,244\n" +
            "Color of model.pixel (2,4): 151,151,151\n" +
            "Color of model.pixel (2,5): 206,206,206\n" +
            "Color of model.pixel (2,6): 213,213,213\n" +
            "Color of model.pixel (3,0): 254,254,254\n" +
            "Color of model.pixel (3,1): 167,167,167\n" +
            "Color of model.pixel (3,2): 198,198,198\n" +
            "Color of model.pixel (3,3): 195,195,195\n" +
            "Color of model.pixel (3,4): 233,233,233\n" +
            "Color of model.pixel (3,5): 138,138,138\n" +
            "Color of model.pixel (3,6): 225,225,225\n" +
            "Color of model.pixel (4,0): 217,217,217\n" +
            "Color of model.pixel (4,1): 197,197,197\n" +
            "Color of model.pixel (4,2): 224,224,224\n" +
            "Color of model.pixel (4,3): 148,148,148\n" +
            "Color of model.pixel (4,4): 187,187,187\n" +
            "Color of model.pixel (4,5): 192,192,192\n" +
            "Color of model.pixel (4,6): 233,233,233\n" +
            "Color of model.pixel (5,0): 236,236,236\n" +
            "Color of model.pixel (5,1): 246,246,246\n" +
            "Color of model.pixel (5,2): 243,243,243\n" +
            "Color of model.pixel (5,3): 156,156,156\n" +
            "Color of model.pixel (5,4): 190,190,190\n" +
            "Color of model.pixel (5,5): 250,250,250\n" +
            "Color of model.pixel (5,6): 230,230,230\n" +
            "Color of model.pixel (6,0): 234,234,234\n" +
            "Color of model.pixel (6,1): 251,251,251\n" +
            "Color of model.pixel (6,2): 242,242,242\n" +
            "Color of model.pixel (6,3): 231,231,231\n" +
            "Color of model.pixel (6,4): 243,243,243\n" +
            "Color of model.pixel (6,5): 255,255,255\n" +
            "Color of model.pixel (6,6): 188,188,188\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,235\n" +
            "Color of model.pixel (0,1): 255,255,230\n" +
            "Color of model.pixel (0,2): 255,255,232\n" +
            "Color of model.pixel (0,3): 255,255,232\n" +
            "Color of model.pixel (0,4): 255,255,224\n" +
            "Color of model.pixel (0,5): 255,239,186\n" +
            "Color of model.pixel (0,6): 240,214,167\n" +
            "Color of model.pixel (1,0): 255,255,237\n" +
            "Color of model.pixel (1,1): 255,255,236\n" +
            "Color of model.pixel (1,2): 255,255,218\n" +
            "Color of model.pixel (1,3): 255,255,217\n" +
            "Color of model.pixel (1,4): 255,255,216\n" +
            "Color of model.pixel (1,5): 255,255,219\n" +
            "Color of model.pixel (1,6): 255,255,238\n" +
            "Color of model.pixel (2,0): 255,255,236\n" +
            "Color of model.pixel (2,1): 255,255,209\n" +
            "Color of model.pixel (2,2): 172,153,119\n" +
            "Color of model.pixel (2,3): 255,255,229\n" +
            "Color of model.pixel (2,4): 204,182,141\n" +
            "Color of model.pixel (2,5): 255,248,193\n" +
            "Color of model.pixel (2,6): 255,255,200\n" +
            "Color of model.pixel (3,0): 255,255,238\n" +
            "Color of model.pixel (3,1): 226,201,156\n" +
            "Color of model.pixel (3,2): 255,238,186\n" +
            "Color of model.pixel (3,3): 255,235,183\n" +
            "Color of model.pixel (3,4): 255,255,218\n" +
            "Color of model.pixel (3,5): 186,166,129\n" +
            "Color of model.pixel (3,6): 255,255,211\n" +
            "Color of model.pixel (4,0): 255,255,203\n" +
            "Color of model.pixel (4,1): 255,237,185\n" +
            "Color of model.pixel (4,2): 255,255,210\n" +
            "Color of model.pixel (4,3): 200,178,139\n" +
            "Color of model.pixel (4,4): 253,225,175\n" +
            "Color of model.pixel (4,5): 255,231,180\n" +
            "Color of model.pixel (4,6): 255,255,218\n" +
            "Color of model.pixel (5,0): 255,255,221\n" +
            "Color of model.pixel (5,1): 255,255,231\n" +
            "Color of model.pixel (5,2): 255,255,228\n" +
            "Color of model.pixel (5,3): 211,188,146\n" +
            "Color of model.pixel (5,4): 255,229,178\n" +
            "Color of model.pixel (5,5): 255,255,234\n" +
            "Color of model.pixel (5,6): 255,255,216\n" +
            "Color of model.pixel (6,0): 255,255,219\n" +
            "Color of model.pixel (6,1): 255,255,235\n" +
            "Color of model.pixel (6,2): 255,255,227\n" +
            "Color of model.pixel (6,3): 255,255,216\n" +
            "Color of model.pixel (6,4): 255,255,228\n" +
            "Color of model.pixel (6,5): 255,255,239\n" +
            "Color of model.pixel (6,6): 254,226,176\n" +
            "\n", a.toString());


  }

  // red component on jpeg
  @Test
  public void imageProcessorPPM1121118() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this red-component this this-red");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,249,249\n" +
            "Color of model.pixel (0,1): 243,243,243\n" +
            "Color of model.pixel (0,2): 246,246,246\n" +
            "Color of model.pixel (0,3): 246,246,246\n" +
            "Color of model.pixel (0,4): 237,237,237\n" +
            "Color of model.pixel (0,5): 197,197,197\n" +
            "Color of model.pixel (0,6): 176,176,176\n" +
            "Color of model.pixel (1,0): 252,252,252\n" +
            "Color of model.pixel (1,1): 250,250,250\n" +
            "Color of model.pixel (1,2): 231,231,231\n" +
            "Color of model.pixel (1,3): 230,230,230\n" +
            "Color of model.pixel (1,4): 229,229,229\n" +
            "Color of model.pixel (1,5): 232,232,232\n" +
            "Color of model.pixel (1,6): 254,254,254\n" +
            "Color of model.pixel (2,0): 250,250,250\n" +
            "Color of model.pixel (2,1): 221,221,221\n" +
            "Color of model.pixel (2,2): 125,125,125\n" +
            "Color of model.pixel (2,3): 242,242,242\n" +
            "Color of model.pixel (2,4): 149,149,149\n" +
            "Color of model.pixel (2,5): 204,204,204\n" +
            "Color of model.pixel (2,6): 211,211,211\n" +
            "Color of model.pixel (3,0): 253,253,253\n" +
            "Color of model.pixel (3,1): 165,165,165\n" +
            "Color of model.pixel (3,2): 196,196,196\n" +
            "Color of model.pixel (3,3): 193,193,193\n" +
            "Color of model.pixel (3,4): 231,231,231\n" +
            "Color of model.pixel (3,5): 136,136,136\n" +
            "Color of model.pixel (3,6): 223,223,223\n" +
            "Color of model.pixel (4,0): 215,215,215\n" +
            "Color of model.pixel (4,1): 195,195,195\n" +
            "Color of model.pixel (4,2): 222,222,222\n" +
            "Color of model.pixel (4,3): 146,146,146\n" +
            "Color of model.pixel (4,4): 185,185,185\n" +
            "Color of model.pixel (4,5): 190,190,190\n" +
            "Color of model.pixel (4,6): 231,231,231\n" +
            "Color of model.pixel (5,0): 235,235,235\n" +
            "Color of model.pixel (5,1): 245,245,245\n" +
            "Color of model.pixel (5,2): 242,242,242\n" +
            "Color of model.pixel (5,3): 155,155,155\n" +
            "Color of model.pixel (5,4): 189,189,189\n" +
            "Color of model.pixel (5,5): 249,249,249\n" +
            "Color of model.pixel (5,6): 229,229,229\n" +
            "Color of model.pixel (6,0): 232,232,232\n" +
            "Color of model.pixel (6,1): 249,249,249\n" +
            "Color of model.pixel (6,2): 240,240,240\n" +
            "Color of model.pixel (6,3): 229,229,229\n" +
            "Color of model.pixel (6,4): 241,241,241\n" +
            "Color of model.pixel (6,5): 254,254,254\n" +
            "Color of model.pixel (6,6): 186,186,186\n" +
            "\n", a.toString());


  }

  // green component on jpeg
  @Test
  public void imageProcessorPPM1121119() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this green-component this this-green");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 253,253,253\n" +
            "Color of model.pixel (0,1): 247,247,247\n" +
            "Color of model.pixel (0,2): 250,250,250\n" +
            "Color of model.pixel (0,3): 250,250,250\n" +
            "Color of model.pixel (0,4): 241,241,241\n" +
            "Color of model.pixel (0,5): 201,201,201\n" +
            "Color of model.pixel (0,6): 180,180,180\n" +
            "Color of model.pixel (1,0): 255,255,255\n" +
            "Color of model.pixel (1,1): 254,254,254\n" +
            "Color of model.pixel (1,2): 235,235,235\n" +
            "Color of model.pixel (1,3): 234,234,234\n" +
            "Color of model.pixel (1,4): 233,233,233\n" +
            "Color of model.pixel (1,5): 236,236,236\n" +
            "Color of model.pixel (1,6): 255,255,255\n" +
            "Color of model.pixel (2,0): 253,253,253\n" +
            "Color of model.pixel (2,1): 224,224,224\n" +
            "Color of model.pixel (2,2): 128,128,128\n" +
            "Color of model.pixel (2,3): 245,245,245\n" +
            "Color of model.pixel (2,4): 152,152,152\n" +
            "Color of model.pixel (2,5): 207,207,207\n" +
            "Color of model.pixel (2,6): 214,214,214\n" +
            "Color of model.pixel (3,0): 255,255,255\n" +
            "Color of model.pixel (3,1): 168,168,168\n" +
            "Color of model.pixel (3,2): 199,199,199\n" +
            "Color of model.pixel (3,3): 196,196,196\n" +
            "Color of model.pixel (3,4): 234,234,234\n" +
            "Color of model.pixel (3,5): 139,139,139\n" +
            "Color of model.pixel (3,6): 226,226,226\n" +
            "Color of model.pixel (4,0): 218,218,218\n" +
            "Color of model.pixel (4,1): 198,198,198\n" +
            "Color of model.pixel (4,2): 225,225,225\n" +
            "Color of model.pixel (4,3): 149,149,149\n" +
            "Color of model.pixel (4,4): 188,188,188\n" +
            "Color of model.pixel (4,5): 193,193,193\n" +
            "Color of model.pixel (4,6): 234,234,234\n" +
            "Color of model.pixel (5,0): 237,237,237\n" +
            "Color of model.pixel (5,1): 247,247,247\n" +
            "Color of model.pixel (5,2): 244,244,244\n" +
            "Color of model.pixel (5,3): 157,157,157\n" +
            "Color of model.pixel (5,4): 191,191,191\n" +
            "Color of model.pixel (5,5): 251,251,251\n" +
            "Color of model.pixel (5,6): 231,231,231\n" +
            "Color of model.pixel (6,0): 234,234,234\n" +
            "Color of model.pixel (6,1): 251,251,251\n" +
            "Color of model.pixel (6,2): 242,242,242\n" +
            "Color of model.pixel (6,3): 231,231,231\n" +
            "Color of model.pixel (6,4): 243,243,243\n" +
            "Color of model.pixel (6,5): 255,255,255\n" +
            "Color of model.pixel (6,6): 188,188,188\n" +
            "\n", a.toString());


  }

  // blue component on jpeg
  @Test
  public void imageProcessorPPM1121120() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this blue-component this this-blue");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 239,239,239\n" +
            "Color of model.pixel (0,1): 233,233,233\n" +
            "Color of model.pixel (0,2): 236,236,236\n" +
            "Color of model.pixel (0,3): 236,236,236\n" +
            "Color of model.pixel (0,4): 227,227,227\n" +
            "Color of model.pixel (0,5): 187,187,187\n" +
            "Color of model.pixel (0,6): 166,166,166\n" +
            "Color of model.pixel (1,0): 242,242,242\n" +
            "Color of model.pixel (1,1): 240,240,240\n" +
            "Color of model.pixel (1,2): 221,221,221\n" +
            "Color of model.pixel (1,3): 220,220,220\n" +
            "Color of model.pixel (1,4): 219,219,219\n" +
            "Color of model.pixel (1,5): 222,222,222\n" +
            "Color of model.pixel (1,6): 244,244,244\n" +
            "Color of model.pixel (2,0): 242,242,242\n" +
            "Color of model.pixel (2,1): 213,213,213\n" +
            "Color of model.pixel (2,2): 117,117,117\n" +
            "Color of model.pixel (2,3): 234,234,234\n" +
            "Color of model.pixel (2,4): 141,141,141\n" +
            "Color of model.pixel (2,5): 196,196,196\n" +
            "Color of model.pixel (2,6): 203,203,203\n" +
            "Color of model.pixel (3,0): 247,247,247\n" +
            "Color of model.pixel (3,1): 159,159,159\n" +
            "Color of model.pixel (3,2): 190,190,190\n" +
            "Color of model.pixel (3,3): 187,187,187\n" +
            "Color of model.pixel (3,4): 225,225,225\n" +
            "Color of model.pixel (3,5): 130,130,130\n" +
            "Color of model.pixel (3,6): 217,217,217\n" +
            "Color of model.pixel (4,0): 211,211,211\n" +
            "Color of model.pixel (4,1): 191,191,191\n" +
            "Color of model.pixel (4,2): 218,218,218\n" +
            "Color of model.pixel (4,3): 142,142,142\n" +
            "Color of model.pixel (4,4): 181,181,181\n" +
            "Color of model.pixel (4,5): 186,186,186\n" +
            "Color of model.pixel (4,6): 227,227,227\n" +
            "Color of model.pixel (5,0): 232,232,232\n" +
            "Color of model.pixel (5,1): 242,242,242\n" +
            "Color of model.pixel (5,2): 239,239,239\n" +
            "Color of model.pixel (5,3): 152,152,152\n" +
            "Color of model.pixel (5,4): 186,186,186\n" +
            "Color of model.pixel (5,5): 246,246,246\n" +
            "Color of model.pixel (5,6): 226,226,226\n" +
            "Color of model.pixel (6,0): 233,233,233\n" +
            "Color of model.pixel (6,1): 250,250,250\n" +
            "Color of model.pixel (6,2): 241,241,241\n" +
            "Color of model.pixel (6,3): 230,230,230\n" +
            "Color of model.pixel (6,4): 242,242,242\n" +
            "Color of model.pixel (6,5): 255,255,255\n" +
            "Color of model.pixel (6,6): 187,187,187\n" +
            "\n", a.toString());


  }

  // value component on jpeg
  @Test
  public void imageProcessorPPM1121121() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this value-component this this-value");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 253,253,253\n" +
            "Color of model.pixel (0,1): 247,247,247\n" +
            "Color of model.pixel (0,2): 250,250,250\n" +
            "Color of model.pixel (0,3): 250,250,250\n" +
            "Color of model.pixel (0,4): 241,241,241\n" +
            "Color of model.pixel (0,5): 201,201,201\n" +
            "Color of model.pixel (0,6): 180,180,180\n" +
            "Color of model.pixel (1,0): 255,255,255\n" +
            "Color of model.pixel (1,1): 254,254,254\n" +
            "Color of model.pixel (1,2): 235,235,235\n" +
            "Color of model.pixel (1,3): 234,234,234\n" +
            "Color of model.pixel (1,4): 233,233,233\n" +
            "Color of model.pixel (1,5): 236,236,236\n" +
            "Color of model.pixel (1,6): 255,255,255\n" +
            "Color of model.pixel (2,0): 253,253,253\n" +
            "Color of model.pixel (2,1): 224,224,224\n" +
            "Color of model.pixel (2,2): 128,128,128\n" +
            "Color of model.pixel (2,3): 245,245,245\n" +
            "Color of model.pixel (2,4): 152,152,152\n" +
            "Color of model.pixel (2,5): 207,207,207\n" +
            "Color of model.pixel (2,6): 214,214,214\n" +
            "Color of model.pixel (3,0): 255,255,255\n" +
            "Color of model.pixel (3,1): 168,168,168\n" +
            "Color of model.pixel (3,2): 199,199,199\n" +
            "Color of model.pixel (3,3): 196,196,196\n" +
            "Color of model.pixel (3,4): 234,234,234\n" +
            "Color of model.pixel (3,5): 139,139,139\n" +
            "Color of model.pixel (3,6): 226,226,226\n" +
            "Color of model.pixel (4,0): 218,218,218\n" +
            "Color of model.pixel (4,1): 198,198,198\n" +
            "Color of model.pixel (4,2): 225,225,225\n" +
            "Color of model.pixel (4,3): 149,149,149\n" +
            "Color of model.pixel (4,4): 188,188,188\n" +
            "Color of model.pixel (4,5): 193,193,193\n" +
            "Color of model.pixel (4,6): 234,234,234\n" +
            "Color of model.pixel (5,0): 237,237,237\n" +
            "Color of model.pixel (5,1): 247,247,247\n" +
            "Color of model.pixel (5,2): 244,244,244\n" +
            "Color of model.pixel (5,3): 157,157,157\n" +
            "Color of model.pixel (5,4): 191,191,191\n" +
            "Color of model.pixel (5,5): 251,251,251\n" +
            "Color of model.pixel (5,6): 231,231,231\n" +
            "Color of model.pixel (6,0): 234,234,234\n" +
            "Color of model.pixel (6,1): 251,251,251\n" +
            "Color of model.pixel (6,2): 242,242,242\n" +
            "Color of model.pixel (6,3): 231,231,231\n" +
            "Color of model.pixel (6,4): 243,243,243\n" +
            "Color of model.pixel (6,5): 255,255,255\n" +
            "Color of model.pixel (6,6): 188,188,188\n" +
            "\n", a.toString());


  }

  // luma component on jpeg
  @Test
  public void imageProcessorPPM1121122() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this luma-component this this-luma");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 242,242,242\n" +
            "Color of model.pixel (0,1): 236,236,236\n" +
            "Color of model.pixel (0,2): 239,239,239\n" +
            "Color of model.pixel (0,3): 239,239,239\n" +
            "Color of model.pixel (0,4): 230,230,230\n" +
            "Color of model.pixel (0,5): 190,190,190\n" +
            "Color of model.pixel (0,6): 169,169,169\n" +
            "Color of model.pixel (1,0): 245,245,245\n" +
            "Color of model.pixel (1,1): 243,243,243\n" +
            "Color of model.pixel (1,2): 224,224,224\n" +
            "Color of model.pixel (1,3): 223,223,223\n" +
            "Color of model.pixel (1,4): 222,222,222\n" +
            "Color of model.pixel (1,5): 225,225,225\n" +
            "Color of model.pixel (1,6): 247,247,247\n" +
            "Color of model.pixel (2,0): 244,244,244\n" +
            "Color of model.pixel (2,1): 215,215,215\n" +
            "Color of model.pixel (2,2): 119,119,119\n" +
            "Color of model.pixel (2,3): 236,236,236\n" +
            "Color of model.pixel (2,4): 143,143,143\n" +
            "Color of model.pixel (2,5): 198,198,198\n" +
            "Color of model.pixel (2,6): 205,205,205\n" +
            "Color of model.pixel (3,0): 249,249,249\n" +
            "Color of model.pixel (3,1): 161,161,161\n" +
            "Color of model.pixel (3,2): 192,192,192\n" +
            "Color of model.pixel (3,3): 189,189,189\n" +
            "Color of model.pixel (3,4): 227,227,227\n" +
            "Color of model.pixel (3,5): 132,132,132\n" +
            "Color of model.pixel (3,6): 219,219,219\n" +
            "Color of model.pixel (4,0): 212,212,212\n" +
            "Color of model.pixel (4,1): 192,192,192\n" +
            "Color of model.pixel (4,2): 219,219,219\n" +
            "Color of model.pixel (4,3): 143,143,143\n" +
            "Color of model.pixel (4,4): 182,182,182\n" +
            "Color of model.pixel (4,5): 187,187,187\n" +
            "Color of model.pixel (4,6): 228,228,228\n" +
            "Color of model.pixel (5,0): 233,233,233\n" +
            "Color of model.pixel (5,1): 243,243,243\n" +
            "Color of model.pixel (5,2): 240,240,240\n" +
            "Color of model.pixel (5,3): 153,153,153\n" +
            "Color of model.pixel (5,4): 187,187,187\n" +
            "Color of model.pixel (5,5): 247,247,247\n" +
            "Color of model.pixel (5,6): 227,227,227\n" +
            "Color of model.pixel (6,0): 233,233,233\n" +
            "Color of model.pixel (6,1): 250,250,250\n" +
            "Color of model.pixel (6,2): 241,241,241\n" +
            "Color of model.pixel (6,3): 230,230,230\n" +
            "Color of model.pixel (6,4): 242,242,242\n" +
            "Color of model.pixel (6,5): 255,255,255\n" +
            "Color of model.pixel (6,6): 187,187,187\n" +
            "\n", a.toString());


  }

  // intensity component on jpeg
  @Test
  public void imageProcessorPPM1121123() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this intensity-component this this-intensity");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 247,247,247\n" +
            "Color of model.pixel (0,1): 241,241,241\n" +
            "Color of model.pixel (0,2): 244,244,244\n" +
            "Color of model.pixel (0,3): 244,244,244\n" +
            "Color of model.pixel (0,4): 235,235,235\n" +
            "Color of model.pixel (0,5): 195,195,195\n" +
            "Color of model.pixel (0,6): 174,174,174\n" +
            "Color of model.pixel (1,0): 249,249,249\n" +
            "Color of model.pixel (1,1): 248,248,248\n" +
            "Color of model.pixel (1,2): 229,229,229\n" +
            "Color of model.pixel (1,3): 228,228,228\n" +
            "Color of model.pixel (1,4): 227,227,227\n" +
            "Color of model.pixel (1,5): 230,230,230\n" +
            "Color of model.pixel (1,6): 251,251,251\n" +
            "Color of model.pixel (2,0): 248,248,248\n" +
            "Color of model.pixel (2,1): 219,219,219\n" +
            "Color of model.pixel (2,2): 123,123,123\n" +
            "Color of model.pixel (2,3): 240,240,240\n" +
            "Color of model.pixel (2,4): 147,147,147\n" +
            "Color of model.pixel (2,5): 202,202,202\n" +
            "Color of model.pixel (2,6): 209,209,209\n" +
            "Color of model.pixel (3,0): 251,251,251\n" +
            "Color of model.pixel (3,1): 164,164,164\n" +
            "Color of model.pixel (3,2): 195,195,195\n" +
            "Color of model.pixel (3,3): 192,192,192\n" +
            "Color of model.pixel (3,4): 230,230,230\n" +
            "Color of model.pixel (3,5): 135,135,135\n" +
            "Color of model.pixel (3,6): 222,222,222\n" +
            "Color of model.pixel (4,0): 214,214,214\n" +
            "Color of model.pixel (4,1): 194,194,194\n" +
            "Color of model.pixel (4,2): 221,221,221\n" +
            "Color of model.pixel (4,3): 145,145,145\n" +
            "Color of model.pixel (4,4): 184,184,184\n" +
            "Color of model.pixel (4,5): 189,189,189\n" +
            "Color of model.pixel (4,6): 230,230,230\n" +
            "Color of model.pixel (5,0): 234,234,234\n" +
            "Color of model.pixel (5,1): 244,244,244\n" +
            "Color of model.pixel (5,2): 241,241,241\n" +
            "Color of model.pixel (5,3): 154,154,154\n" +
            "Color of model.pixel (5,4): 188,188,188\n" +
            "Color of model.pixel (5,5): 248,248,248\n" +
            "Color of model.pixel (5,6): 228,228,228\n" +
            "Color of model.pixel (6,0): 233,233,233\n" +
            "Color of model.pixel (6,1): 250,250,250\n" +
            "Color of model.pixel (6,2): 241,241,241\n" +
            "Color of model.pixel (6,3): 230,230,230\n" +
            "Color of model.pixel (6,4): 242,242,242\n" +
            "Color of model.pixel (6,5): 254,254,254\n" +
            "Color of model.pixel (6,6): 187,187,187\n" +
            "\n", a.toString());


  }

  // brighten on jpeg
  @Test
  public void imageProcessorPPM1121124() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this brighten 20 this this-brighten");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 255,255,255\n" +
            "Color of model.pixel (0,1): 255,255,253\n" +
            "Color of model.pixel (0,2): 255,255,255\n" +
            "Color of model.pixel (0,3): 255,255,255\n" +
            "Color of model.pixel (0,4): 255,255,247\n" +
            "Color of model.pixel (0,5): 217,221,207\n" +
            "Color of model.pixel (0,6): 196,200,186\n" +
            "Color of model.pixel (1,0): 255,255,255\n" +
            "Color of model.pixel (1,1): 255,255,255\n" +
            "Color of model.pixel (1,2): 251,255,241\n" +
            "Color of model.pixel (1,3): 250,254,240\n" +
            "Color of model.pixel (1,4): 249,253,239\n" +
            "Color of model.pixel (1,5): 252,255,242\n" +
            "Color of model.pixel (1,6): 255,255,255\n" +
            "Color of model.pixel (2,0): 255,255,255\n" +
            "Color of model.pixel (2,1): 241,244,233\n" +
            "Color of model.pixel (2,2): 145,148,137\n" +
            "Color of model.pixel (2,3): 255,255,254\n" +
            "Color of model.pixel (2,4): 169,172,161\n" +
            "Color of model.pixel (2,5): 224,227,216\n" +
            "Color of model.pixel (2,6): 231,234,223\n" +
            "Color of model.pixel (3,0): 255,255,255\n" +
            "Color of model.pixel (3,1): 185,188,179\n" +
            "Color of model.pixel (3,2): 216,219,210\n" +
            "Color of model.pixel (3,3): 213,216,207\n" +
            "Color of model.pixel (3,4): 251,254,245\n" +
            "Color of model.pixel (3,5): 156,159,150\n" +
            "Color of model.pixel (3,6): 243,246,237\n" +
            "Color of model.pixel (4,0): 235,238,231\n" +
            "Color of model.pixel (4,1): 215,218,211\n" +
            "Color of model.pixel (4,2): 242,245,238\n" +
            "Color of model.pixel (4,3): 166,169,162\n" +
            "Color of model.pixel (4,4): 205,208,201\n" +
            "Color of model.pixel (4,5): 210,213,206\n" +
            "Color of model.pixel (4,6): 251,254,247\n" +
            "Color of model.pixel (5,0): 255,255,252\n" +
            "Color of model.pixel (5,1): 255,255,255\n" +
            "Color of model.pixel (5,2): 255,255,255\n" +
            "Color of model.pixel (5,3): 175,177,172\n" +
            "Color of model.pixel (5,4): 209,211,206\n" +
            "Color of model.pixel (5,5): 255,255,255\n" +
            "Color of model.pixel (5,6): 249,251,246\n" +
            "Color of model.pixel (6,0): 252,254,253\n" +
            "Color of model.pixel (6,1): 255,255,255\n" +
            "Color of model.pixel (6,2): 255,255,255\n" +
            "Color of model.pixel (6,3): 249,251,250\n" +
            "Color of model.pixel (6,4): 255,255,255\n" +
            "Color of model.pixel (6,5): 255,255,255\n" +
            "Color of model.pixel (6,6): 206,208,207\n" +
            "\n", a.toString());


  }

  // darken on jpeg
  @Test
  public void imageProcessorPPM1121126() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this darken 20 this this-darken");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 229,233,219\n" +
            "Color of model.pixel (0,1): 223,227,213\n" +
            "Color of model.pixel (0,2): 226,230,216\n" +
            "Color of model.pixel (0,3): 226,230,216\n" +
            "Color of model.pixel (0,4): 217,221,207\n" +
            "Color of model.pixel (0,5): 177,181,167\n" +
            "Color of model.pixel (0,6): 156,160,146\n" +
            "Color of model.pixel (1,0): 232,235,222\n" +
            "Color of model.pixel (1,1): 230,234,220\n" +
            "Color of model.pixel (1,2): 211,215,201\n" +
            "Color of model.pixel (1,3): 210,214,200\n" +
            "Color of model.pixel (1,4): 209,213,199\n" +
            "Color of model.pixel (1,5): 212,216,202\n" +
            "Color of model.pixel (1,6): 234,235,224\n" +
            "Color of model.pixel (2,0): 230,233,222\n" +
            "Color of model.pixel (2,1): 201,204,193\n" +
            "Color of model.pixel (2,2): 105,108,97\n" +
            "Color of model.pixel (2,3): 222,225,214\n" +
            "Color of model.pixel (2,4): 129,132,121\n" +
            "Color of model.pixel (2,5): 184,187,176\n" +
            "Color of model.pixel (2,6): 191,194,183\n" +
            "Color of model.pixel (3,0): 233,235,227\n" +
            "Color of model.pixel (3,1): 145,148,139\n" +
            "Color of model.pixel (3,2): 176,179,170\n" +
            "Color of model.pixel (3,3): 173,176,167\n" +
            "Color of model.pixel (3,4): 211,214,205\n" +
            "Color of model.pixel (3,5): 116,119,110\n" +
            "Color of model.pixel (3,6): 203,206,197\n" +
            "Color of model.pixel (4,0): 195,198,191\n" +
            "Color of model.pixel (4,1): 175,178,171\n" +
            "Color of model.pixel (4,2): 202,205,198\n" +
            "Color of model.pixel (4,3): 126,129,122\n" +
            "Color of model.pixel (4,4): 165,168,161\n" +
            "Color of model.pixel (4,5): 170,173,166\n" +
            "Color of model.pixel (4,6): 211,214,207\n" +
            "Color of model.pixel (5,0): 215,217,212\n" +
            "Color of model.pixel (5,1): 225,227,222\n" +
            "Color of model.pixel (5,2): 222,224,219\n" +
            "Color of model.pixel (5,3): 135,137,132\n" +
            "Color of model.pixel (5,4): 169,171,166\n" +
            "Color of model.pixel (5,5): 229,231,226\n" +
            "Color of model.pixel (5,6): 209,211,206\n" +
            "Color of model.pixel (6,0): 212,214,213\n" +
            "Color of model.pixel (6,1): 229,231,230\n" +
            "Color of model.pixel (6,2): 220,222,221\n" +
            "Color of model.pixel (6,3): 209,211,210\n" +
            "Color of model.pixel (6,4): 221,223,222\n" +
            "Color of model.pixel (6,5): 234,235,235\n" +
            "Color of model.pixel (6,6): 166,168,167\n" +
            "\n", a.toString());


  }

  // vertical flip on jpeg
  @Test
  public void imageProcessorPPM1121125() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this vertical-flip this this-vflip");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 176,180,166\n" +
            "Color of model.pixel (0,1): 197,201,187\n" +
            "Color of model.pixel (0,2): 237,241,227\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 246,250,236\n" +
            "Color of model.pixel (0,5): 243,247,233\n" +
            "Color of model.pixel (0,6): 249,253,239\n" +
            "Color of model.pixel (1,0): 254,255,244\n" +
            "Color of model.pixel (1,1): 232,236,222\n" +
            "Color of model.pixel (1,2): 229,233,219\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 231,235,221\n" +
            "Color of model.pixel (1,5): 250,254,240\n" +
            "Color of model.pixel (1,6): 252,255,242\n" +
            "Color of model.pixel (2,0): 211,214,203\n" +
            "Color of model.pixel (2,1): 204,207,196\n" +
            "Color of model.pixel (2,2): 149,152,141\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 125,128,117\n" +
            "Color of model.pixel (2,5): 221,224,213\n" +
            "Color of model.pixel (2,6): 250,253,242\n" +
            "Color of model.pixel (3,0): 223,226,217\n" +
            "Color of model.pixel (3,1): 136,139,130\n" +
            "Color of model.pixel (3,2): 231,234,225\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 196,199,190\n" +
            "Color of model.pixel (3,5): 165,168,159\n" +
            "Color of model.pixel (3,6): 253,255,247\n" +
            "Color of model.pixel (4,0): 231,234,227\n" +
            "Color of model.pixel (4,1): 190,193,186\n" +
            "Color of model.pixel (4,2): 185,188,181\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 222,225,218\n" +
            "Color of model.pixel (4,5): 195,198,191\n" +
            "Color of model.pixel (4,6): 215,218,211\n" +
            "Color of model.pixel (5,0): 229,231,226\n" +
            "Color of model.pixel (5,1): 249,251,246\n" +
            "Color of model.pixel (5,2): 189,191,186\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 242,244,239\n" +
            "Color of model.pixel (5,5): 245,247,242\n" +
            "Color of model.pixel (5,6): 235,237,232\n" +
            "Color of model.pixel (6,0): 186,188,187\n" +
            "Color of model.pixel (6,1): 254,255,255\n" +
            "Color of model.pixel (6,2): 241,243,242\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 240,242,241\n" +
            "Color of model.pixel (6,5): 249,251,250\n" +
            "Color of model.pixel (6,6): 232,234,233\n" +
            "\n", a.toString());


  }

  // horizontal flip on jpeg
  @Test
  public void imageProcessorPPM1121127() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this horizontal-flip this this-hflip");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 232,234,233\n" +
            "Color of model.pixel (0,1): 249,251,250\n" +
            "Color of model.pixel (0,2): 240,242,241\n" +
            "Color of model.pixel (0,3): 229,231,230\n" +
            "Color of model.pixel (0,4): 241,243,242\n" +
            "Color of model.pixel (0,5): 254,255,255\n" +
            "Color of model.pixel (0,6): 186,188,187\n" +
            "Color of model.pixel (1,0): 235,237,232\n" +
            "Color of model.pixel (1,1): 245,247,242\n" +
            "Color of model.pixel (1,2): 242,244,239\n" +
            "Color of model.pixel (1,3): 155,157,152\n" +
            "Color of model.pixel (1,4): 189,191,186\n" +
            "Color of model.pixel (1,5): 249,251,246\n" +
            "Color of model.pixel (1,6): 229,231,226\n" +
            "Color of model.pixel (2,0): 215,218,211\n" +
            "Color of model.pixel (2,1): 195,198,191\n" +
            "Color of model.pixel (2,2): 222,225,218\n" +
            "Color of model.pixel (2,3): 146,149,142\n" +
            "Color of model.pixel (2,4): 185,188,181\n" +
            "Color of model.pixel (2,5): 190,193,186\n" +
            "Color of model.pixel (2,6): 231,234,227\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 250,253,242\n" +
            "Color of model.pixel (4,1): 221,224,213\n" +
            "Color of model.pixel (4,2): 125,128,117\n" +
            "Color of model.pixel (4,3): 242,245,234\n" +
            "Color of model.pixel (4,4): 149,152,141\n" +
            "Color of model.pixel (4,5): 204,207,196\n" +
            "Color of model.pixel (4,6): 211,214,203\n" +
            "Color of model.pixel (5,0): 252,255,242\n" +
            "Color of model.pixel (5,1): 250,254,240\n" +
            "Color of model.pixel (5,2): 231,235,221\n" +
            "Color of model.pixel (5,3): 230,234,220\n" +
            "Color of model.pixel (5,4): 229,233,219\n" +
            "Color of model.pixel (5,5): 232,236,222\n" +
            "Color of model.pixel (5,6): 254,255,244\n" +
            "Color of model.pixel (6,0): 249,253,239\n" +
            "Color of model.pixel (6,1): 243,247,233\n" +
            "Color of model.pixel (6,2): 246,250,236\n" +
            "Color of model.pixel (6,3): 246,250,236\n" +
            "Color of model.pixel (6,4): 237,241,227\n" +
            "Color of model.pixel (6,5): 197,201,187\n" +
            "Color of model.pixel (6,6): 176,180,166\n" +
            "\n", a.toString());


  }

  // horizontal flip and blur on jpeg
  @Test
  public void imageProcessorPPM1121128() throws IOException {
    Readable in = new StringReader(
            "load ./res/googleSMALL.jpg this horizontal-flip this this-hflip blur this-hflip "
                    + "this-hflip-blur");
    IModel model = new ImageEditor();
    Appendable a = new StringBuilder();
    IView view = new TextView(model, a);
    IController controller = new TextController(model, view, in);
    controller.imageProcessor();

    assertEquals("Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 249,253,239\n" +
            "Color of model.pixel (0,1): 243,247,233\n" +
            "Color of model.pixel (0,2): 246,250,236\n" +
            "Color of model.pixel (0,3): 246,250,236\n" +
            "Color of model.pixel (0,4): 237,241,227\n" +
            "Color of model.pixel (0,5): 197,201,187\n" +
            "Color of model.pixel (0,6): 176,180,166\n" +
            "Color of model.pixel (1,0): 252,255,242\n" +
            "Color of model.pixel (1,1): 250,254,240\n" +
            "Color of model.pixel (1,2): 231,235,221\n" +
            "Color of model.pixel (1,3): 230,234,220\n" +
            "Color of model.pixel (1,4): 229,233,219\n" +
            "Color of model.pixel (1,5): 232,236,222\n" +
            "Color of model.pixel (1,6): 254,255,244\n" +
            "Color of model.pixel (2,0): 250,253,242\n" +
            "Color of model.pixel (2,1): 221,224,213\n" +
            "Color of model.pixel (2,2): 125,128,117\n" +
            "Color of model.pixel (2,3): 242,245,234\n" +
            "Color of model.pixel (2,4): 149,152,141\n" +
            "Color of model.pixel (2,5): 204,207,196\n" +
            "Color of model.pixel (2,6): 211,214,203\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 215,218,211\n" +
            "Color of model.pixel (4,1): 195,198,191\n" +
            "Color of model.pixel (4,2): 222,225,218\n" +
            "Color of model.pixel (4,3): 146,149,142\n" +
            "Color of model.pixel (4,4): 185,188,181\n" +
            "Color of model.pixel (4,5): 190,193,186\n" +
            "Color of model.pixel (4,6): 231,234,227\n" +
            "Color of model.pixel (5,0): 235,237,232\n" +
            "Color of model.pixel (5,1): 245,247,242\n" +
            "Color of model.pixel (5,2): 242,244,239\n" +
            "Color of model.pixel (5,3): 155,157,152\n" +
            "Color of model.pixel (5,4): 189,191,186\n" +
            "Color of model.pixel (5,5): 249,251,246\n" +
            "Color of model.pixel (5,6): 229,231,226\n" +
            "Color of model.pixel (6,0): 232,234,233\n" +
            "Color of model.pixel (6,1): 249,251,250\n" +
            "Color of model.pixel (6,2): 240,242,241\n" +
            "Color of model.pixel (6,3): 229,231,230\n" +
            "Color of model.pixel (6,4): 241,243,242\n" +
            "Color of model.pixel (6,5): 254,255,255\n" +
            "Color of model.pixel (6,6): 186,188,187\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 232,234,233\n" +
            "Color of model.pixel (0,1): 249,251,250\n" +
            "Color of model.pixel (0,2): 240,242,241\n" +
            "Color of model.pixel (0,3): 229,231,230\n" +
            "Color of model.pixel (0,4): 241,243,242\n" +
            "Color of model.pixel (0,5): 254,255,255\n" +
            "Color of model.pixel (0,6): 186,188,187\n" +
            "Color of model.pixel (1,0): 235,237,232\n" +
            "Color of model.pixel (1,1): 245,247,242\n" +
            "Color of model.pixel (1,2): 242,244,239\n" +
            "Color of model.pixel (1,3): 155,157,152\n" +
            "Color of model.pixel (1,4): 189,191,186\n" +
            "Color of model.pixel (1,5): 249,251,246\n" +
            "Color of model.pixel (1,6): 229,231,226\n" +
            "Color of model.pixel (2,0): 215,218,211\n" +
            "Color of model.pixel (2,1): 195,198,191\n" +
            "Color of model.pixel (2,2): 222,225,218\n" +
            "Color of model.pixel (2,3): 146,149,142\n" +
            "Color of model.pixel (2,4): 185,188,181\n" +
            "Color of model.pixel (2,5): 190,193,186\n" +
            "Color of model.pixel (2,6): 231,234,227\n" +
            "Color of model.pixel (3,0): 253,255,247\n" +
            "Color of model.pixel (3,1): 165,168,159\n" +
            "Color of model.pixel (3,2): 196,199,190\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 231,234,225\n" +
            "Color of model.pixel (3,5): 136,139,130\n" +
            "Color of model.pixel (3,6): 223,226,217\n" +
            "Color of model.pixel (4,0): 250,253,242\n" +
            "Color of model.pixel (4,1): 221,224,213\n" +
            "Color of model.pixel (4,2): 125,128,117\n" +
            "Color of model.pixel (4,3): 242,245,234\n" +
            "Color of model.pixel (4,4): 149,152,141\n" +
            "Color of model.pixel (4,5): 204,207,196\n" +
            "Color of model.pixel (4,6): 211,214,203\n" +
            "Color of model.pixel (5,0): 252,255,242\n" +
            "Color of model.pixel (5,1): 250,254,240\n" +
            "Color of model.pixel (5,2): 231,235,221\n" +
            "Color of model.pixel (5,3): 230,234,220\n" +
            "Color of model.pixel (5,4): 229,233,219\n" +
            "Color of model.pixel (5,5): 232,236,222\n" +
            "Color of model.pixel (5,6): 254,255,244\n" +
            "Color of model.pixel (6,0): 249,253,239\n" +
            "Color of model.pixel (6,1): 243,247,233\n" +
            "Color of model.pixel (6,2): 246,250,236\n" +
            "Color of model.pixel (6,3): 246,250,236\n" +
            "Color of model.pixel (6,4): 237,241,227\n" +
            "Color of model.pixel (6,5): 197,201,187\n" +
            "Color of model.pixel (6,6): 176,180,166\n" +
            "\n" +
            "Successfully completed operation!\n" +
            "Color of model.pixel (0,0): 134,135,134\n" +
            "Color of model.pixel (0,1): 182,183,181\n" +
            "Color of model.pixel (0,2): 175,177,175\n" +
            "Color of model.pixel (0,3): 164,165,163\n" +
            "Color of model.pixel (0,4): 170,171,169\n" +
            "Color of model.pixel (0,5): 174,175,174\n" +
            "Color of model.pixel (0,6): 122,123,122\n" +
            "Color of model.pixel (1,0): 173,175,171\n" +
            "Color of model.pixel (1,1): 233,235,231\n" +
            "Color of model.pixel (1,2): 219,222,217\n" +
            "Color of model.pixel (1,3): 195,197,193\n" +
            "Color of model.pixel (1,4): 202,204,200\n" +
            "Color of model.pixel (1,5): 223,225,220\n" +
            "Color of model.pixel (1,6): 168,170,167\n" +
            "Color of model.pixel (2,0): 165,167,162\n" +
            "Color of model.pixel (2,1): 213,215,208\n" +
            "Color of model.pixel (2,2): 200,203,196\n" +
            "Color of model.pixel (2,3): 185,187,180\n" +
            "Color of model.pixel (2,4): 187,189,182\n" +
            "Color of model.pixel (2,5): 202,205,198\n" +
            "Color of model.pixel (2,6): 162,164,159\n" +
            "Color of model.pixel (3,0): 168,170,164\n" +
            "Color of model.pixel (3,1): 200,203,194\n" +
            "Color of model.pixel (3,2): 187,190,181\n" +
            "Color of model.pixel (3,3): 193,196,187\n" +
            "Color of model.pixel (3,4): 190,193,184\n" +
            "Color of model.pixel (3,5): 189,192,183\n" +
            "Color of model.pixel (3,6): 153,155,148\n" +
            "Color of model.pixel (4,0): 179,181,173\n" +
            "Color of model.pixel (4,1): 212,215,204\n" +
            "Color of model.pixel (4,2): 195,198,187\n" +
            "Color of model.pixel (4,3): 203,206,195\n" +
            "Color of model.pixel (4,4): 200,203,192\n" +
            "Color of model.pixel (4,5): 201,204,193\n" +
            "Color of model.pixel (4,6): 161,163,155\n" +
            "Color of model.pixel (5,0): 186,188,179\n" +
            "Color of model.pixel (5,1): 235,239,226\n" +
            "Color of model.pixel (5,2): 224,227,214\n" +
            "Color of model.pixel (5,3): 223,227,214\n" +
            "Color of model.pixel (5,4): 219,223,209\n" +
            "Color of model.pixel (5,5): 217,220,207\n" +
            "Color of model.pixel (5,6): 166,168,159\n" +
            "Color of model.pixel (6,0): 140,142,134\n" +
            "Color of model.pixel (6,1): 184,187,177\n" +
            "Color of model.pixel (6,2): 182,185,174\n" +
            "Color of model.pixel (6,3): 179,182,172\n" +
            "Color of model.pixel (6,4): 172,175,165\n" +
            "Color of model.pixel (6,5): 160,163,153\n" +
            "Color of model.pixel (6,6): 115,117,109\n" +
            "\n", a.toString());

  }


}
