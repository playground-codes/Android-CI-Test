package com.quangnguyen.androidcitest;

import java.nio.channels.NonReadableChannelException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Quang Nguyen.
 */

public class ExampleUnitTestUsingMocking {

  @Mock
  private LinkedList<Integer> linkedList;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void linkedList_add() {
    linkedList.add(1);
    verify(linkedList).add(1);
  }

  @Test
  public void linkedList_retrieve() {
    when(linkedList.getFirst()).thenReturn(100);

    int first = linkedList.getFirst();
    assertEquals(100, first);
  }

  @Test
  public void iterator_retrieve() {
    Iterator<String> iterator = mock(Iterator.class);
    when(iterator.next()).thenReturn("Hello").thenReturn("World");
    String msg = iterator.next() + " " + iterator.next() + "!";
    assertEquals("Hello World!", msg);
  }

  @Test
  public void comparator() {
    Comparable<Integer> c = mock(Comparable.class);
    when(c.compareTo(anyInt())).thenReturn(-1);

    assertEquals(-1, c.compareTo(-9));
  }

  @Test
  public void throwException() {
    Properties properties = mock(Properties.class);
    when(properties.get("password")).thenThrow(new IllegalArgumentException("You can not access here"));

    try {
      properties.get("password");
      fail();
    } catch (IllegalArgumentException ex){
      // OK
    }
  }
}
