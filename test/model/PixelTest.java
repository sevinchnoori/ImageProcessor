package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class representing examples of Pixels and tests for the class methods.
 */
public class PixelTest {

  private Pixel p1;
  private Pixel p2;
  private Pixel p3;

  private Pixel p4;

  // invalid constructor - neg x
  @Test(expected = IllegalArgumentException.class)
  public void invalidInitialization1() {
    p1 = new Pixel(-4, 4, 2, 5, 6);
  }

  // invalid constructor - neg y
  @Test(expected = IllegalArgumentException.class)
  public void invalidInitialization2() {
    p1 = new Pixel(4, -97, 22, 45, 164);
  }

  // invalid constructor - neg r
  @Test(expected = IllegalArgumentException.class)
  public void invalidInitialization3() {
    p1 = new Pixel(4, 97, -22, 45, 164);
  }

  // invalid constructor - above 255 r
  @Test(expected = IllegalArgumentException.class)
  public void invalidInitialization4() {
    p1 = new Pixel(4, 97, 789, 45, 164);
  }

  // invalid constructor - neg g
  @Test(expected = IllegalArgumentException.class)
  public void invalidInitialization5() {
    p1 = new Pixel(4, 97, 22, -45, 164);
  }

  // invalid constructor - above 255 g
  @Test(expected = IllegalArgumentException.class)
  public void invalidInitialization6() {
    p1 = new Pixel(4, 97, 89, 945, 164);
  }

  // invalid constructor - neg y
  @Test(expected = IllegalArgumentException.class)
  public void invalidInitialization7() {
    p1 = new Pixel(4, 97, 22, 45, -164);
  }

  // invalid constructor - above 255 y
  @Test(expected = IllegalArgumentException.class)
  public void invalidInitialization8() {
    p1 = new Pixel(4, 97, 89, 945, 2164);
  }


  @Before
  public void init() {
    p1 = new Pixel(4, 4, 10, 30, 30);
    p2 = new Pixel(6, 2, 0, 255, 5);
    p3 = new Pixel(6, 2, 10, 10, 10);
    p4 = new Pixel(3, 8, 3, 3, 2);

  }

  // neg num for setAllColors(int sameNum)
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetAllColors1() {
    p1.setAllColors(-38);
  }

  // above 255 num for setAllColors(int sameNum)
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetAllColors2() {
    p1.setAllColors(2840);
  }

  // r neg num for setNewColors
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetNewColors1() {
    p1.setNewColors(-38, 5, 2);
  }

  // g neg num for setNewColors
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetNewColors2() {
    p1.setNewColors(38, -5, 2);
  }

  // b neg num for setNewColors
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetNewColors3() {
    p1.setNewColors(38, 5, -2);
  }

  // r above 255 for setNewColors
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetNewColors4() {
    p1.setNewColors(838, 5, 2);
  }

  // g above 255 for setNewColors
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetNewColors5() {
    p1.setNewColors(838, 525, 2);
  }


  // b above 255 for setNewColors
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetNewColors6() {
    p1.setNewColors(38, 54, 982);
  }


  @Test
  public void testGetX() {
    assertEquals(p1.getX(), 4);
    assertEquals(p2.getX(), 6);
    assertEquals(p3.getX(), 6);
    assertEquals(p4.getX(), 3);
  }

  @Test
  public void testGetY() {
    assertEquals(p1.getY(), 4);
    assertEquals(p2.getY(), 2);
    assertEquals(p3.getY(), 2);
    assertEquals(p4.getY(), 8);
  }


  @Test
  public void testGetRValue() {
    assertEquals(p1.getR(), 10);
    assertEquals(p2.getR(), 0);
    assertEquals(p3.getR(), 10);
    assertEquals(p4.getR(), 3);

  }

  @Test
  public void testGetGValue() {
    assertEquals(p1.getG(), 30);
    assertEquals(p2.getG(), 255);
    assertEquals(p3.getG(), 10);
    assertEquals(p4.getG(), 3);
  }


  @Test
  public void testGetBValue() {
    assertEquals(p1.getB(), 30);
    assertEquals(p2.getB(), 5);
    assertEquals(p3.getB(), 10);
    assertEquals(p4.getB(), 2);
  }

  @Test
  public void testSetAllColors() {
    p1.setAllColors(35);
    assertEquals(35, p1.getR());
    assertEquals(35, p1.getG());
    assertEquals(35, p1.getB());
    p2.setAllColors(67);
    assertEquals(67, p2.getR());
    assertEquals(67, p2.getG());
    assertEquals(67, p2.getB());
    p3.setAllColors(109);
    assertEquals(109, p3.getR());
    assertEquals(109, p3.getG());
    assertEquals(109, p3.getB());
  }

  @Test
  public void testNewAllColors() {
    p1.setNewColors(10, 30, 30); // sets colors to what they already were
    assertEquals(10, p1.getR());
    assertEquals(30, p1.getG());
    assertEquals(30, p1.getB());
    p2.setNewColors(35, 45, 5); // 1 is the same
    assertEquals(35, p2.getR());
    assertEquals(45, p2.getG());
    assertEquals(5, p2.getB());
    p3.setNewColors(10, 10, 4); // 2 are the same
    assertEquals(10, p3.getR());
    assertEquals(10, p3.getG());
    assertEquals(4, p3.getB());
    p4.setNewColors(0, 4, 64); // all new colors
    assertEquals(0, p4.getR());
    assertEquals(4, p4.getG());
    assertEquals(64, p4.getB());
  }


}

