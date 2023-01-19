package view;


import java.io.IOException;

import controller.GUIController;
import model.IModel;
import model.ImageEditor;

/**
 * main class which runs the Graphical User Interface by taking in the model, view, and
 * the controller.
 */
public class GUIMain {
  public static void main(String[] args) {
    IModel model = new ImageEditor();
    JFrameView view = new JFrameView(model);
    GUIController controller = new GUIController(model, view);
  }
}
