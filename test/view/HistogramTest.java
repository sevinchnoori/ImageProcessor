package view;

import org.junit.Test;


import java.awt.image.BufferedImage;
import java.io.IOException;

import model.IModel;
import model.ImageEditor;


import static org.junit.Assert.*;

/**
 * Class that tests the methods of the IHistogram interface and creates examples of it.
 */
public class HistogramTest {

  @Test
  public void histodate() throws IOException {
    IModel m = new ImageEditor();
    m.load("./res/google.jpg", "g");
    Histogram h = new Histogram(m.retrieveImage());

    int redAm255 = h.histoData(255, IHistogram.HistoType.RED_HISTOGRAM);
    assertEquals(64792, redAm255);
    int redAm0 = h.histoData(0, IHistogram.HistoType.RED_HISTOGRAM);
    assertEquals(0, redAm0);
    int redAm155 = h.histoData(155, IHistogram.HistoType.RED_HISTOGRAM);
    assertEquals(2, redAm155);

    int greenAm255 = h.histoData(255, IHistogram.HistoType.GREEN_HISTOGRAM);
    assertEquals(65379, greenAm255);
    int greenAm0 = h.histoData(0, IHistogram.HistoType.GREEN_HISTOGRAM);
    assertEquals(0, greenAm0);
    int greenAm155 = h.histoData(155, IHistogram.HistoType.GREEN_HISTOGRAM);
    assertEquals(30, greenAm155);

    int blueAm255 = h.histoData(255, IHistogram.HistoType.BLUE_HISTOGRAM);
    assertEquals(64390, blueAm255);
    int blueAm0 = h.histoData(0, IHistogram.HistoType.BLUE_HISTOGRAM);
    assertEquals(112, blueAm0);
    int blueAm155 = h.histoData(155, IHistogram.HistoType.BLUE_HISTOGRAM);
    assertEquals(6, blueAm155);

    int intAm255 = h.histoData(255, IHistogram.HistoType.INTENSITY_HISTOGRAM);
    assertEquals(64792, intAm255);
    int intAm0 = h.histoData(0, IHistogram.HistoType.INTENSITY_HISTOGRAM);
    assertEquals(0, intAm0);
    int intAm155 = h.histoData(155, IHistogram.HistoType.INTENSITY_HISTOGRAM);
    assertEquals(2, intAm155);
  }
  @Test
  public void histoDraw() throws IOException {
    IModel m = new ImageEditor();
    m.load("./res/google.jpg", "g");
    Histogram h = new Histogram(m.retrieveImage());
    BufferedImage histo = h.makeHisto(IHistogram.HistoType.RED_HISTOGRAM);
    assertEquals(375, histo.getWidth());
    assertEquals(500, histo.getHeight());
  }
}