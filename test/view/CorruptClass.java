package view;

import java.io.IOException;


/**
 * corrupt class to test appendables.
 */
public class CorruptClass implements Appendable {

  @Override
  public Appendable append(CharSequence c) throws IOException {
    throw new IOException("IO exception thrown");
  }

  @Override
  public Appendable append(CharSequence c, int begin, int end) throws IOException {
    throw new IOException("IO exception thrown");
  }

  @Override
  public Appendable append(char ch) throws IOException {
    throw new IOException("IO exception thrown");
  }
}
