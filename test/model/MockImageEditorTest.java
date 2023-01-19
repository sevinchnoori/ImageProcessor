package model;
//
//import org.junit.Test;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.io.StringReader;
//
//import controller.IController;
//import controller.TextController;
//import view.IView;
//import view.TextView;
//
//import static org.junit.Assert.assertEquals;
//
///** Mock test that the controller retrieves inputs correctly.
// *
// */
//public class MockImageEditorTest {
//
//  @Test
//  public void load() throws IOException {
//    Reader in = new StringReader("load ./src/images/b.ppm example");
//    IModel model = new ImageEditor();
//    Appendable out = new StringBuilder();
//    IView view = new TextView(model, out);
//    MockImageEditor mock = new MockImageEditor();
//    IController controller = new TextController(mock, view, in);
//    controller.imageProcessor();
//
//    assertEquals("file name:./src/images/b.ppm new name: example", mock.getLog());
//  }
//
//
//  @Test
//  public void load2() throws IOException {
//    Reader in = new StringReader("load ./src/images/a.ppm es");
//    IModel model = new ImageEditor();
//    Appendable out = new StringBuilder();
//    IView view = new TextView(model, out);
//    MockImageEditor mock = new MockImageEditor();
//    IController controller = new TextController(mock, view, in);
//    controller.imageProcessor();
//
//    assertEquals("file name:./src/images/a.ppm new name: es", mock.getLog());
//  }
//}