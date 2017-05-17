package com.quangnguyen.androidcitest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
  int[] samples = new int[]{2, 4, 12, 1, 5};

  @Test
  public void addition_isCorrect() throws Exception {
    assertEquals(4, 2 + 2);
  }

  @Test
  public void subtraction_isCorrect() {
    assertEquals(1, 3 - 2);
  }

  @Test
  public void sort_array() {
    Arrays.sort(samples);
    assertArrayEquals(samples, new int[]{1, 2, 4, 5, 12});
  }

  @Test
  public void isEmpty() {
    String hello = "Hello Test";
    assertFalse(hello.isEmpty());
    
    String anotherHello = "";
    assertTrue(anotherHello.isEmpty());

    List<Integer> list = new ArrayList<>(100);
    assertTrue(list.isEmpty());
    list.add(1);
    list.add(2);
    assertFalse(list.isEmpty());
  }
}