package controller;

import org.junit.Test;

import java.awt.event.ActionEvent;
import java.io.IOException;

import model.IModel;
import model.ImageEditor;
import view.JFrameView;

import static org.junit.Assert.*;

public class GUIControllerTest {

  @Test
  public void actionPerformed() throws IOException {
    IModel m = new ImageEditor();
    m.load("./res/google.jpg", "");
    JFrameView v = new JFrameView( m);
    GUIController con = new GUIController(m, v);
    ActionEvent e = new ActionEvent(new JFrameView(m), 0, "load button");
    con.actionPerformed(e);


    // HOW TO ASSET EQUALS THIS?????
  }
}