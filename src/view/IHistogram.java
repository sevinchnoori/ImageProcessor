package view;

import java.awt.image.BufferedImage;

/**
 * Interface that creates a histogram. Includes methods for gathering the data for the histogram
 * and actually creating an image for it.
 */
public interface IHistogram {
  enum HistoType {RED_HISTOGRAM, GREEN_HISTOGRAM, BLUE_HISTOGRAM, INTENSITY_HISTOGRAM}
  int histoData(int num, HistoType type);
  BufferedImage makeHisto(HistoType type);

}
