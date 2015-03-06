package com.springer.drawing

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._

class BorderTest {

  @Test
  def drawABorder() {
    val array: Array[Array[Char]] = Array.ofDim(3, 3)
    val expected = Array(
      Array('=', '=', '='),
      Array('*', ' ', '*'),
      Array('=', '=', '=')
    )
    Border('=', '*').applyTo(array)
    assertThat(array, is(expected))
  }

  @Test (expected = classOf[CannotApplyBorder])
  def failIfArrayIsNotOfUniformSize() {
    val array = Array(
      Array('x', 'x', 'x'),
      Array('x', 'x', 'x', 'x'),
      Array('x', 'x', 'x')
    )
    Border('=', '*').applyTo(array)
  }

  @Test
  def drawABorderForATinyArray() {
    val array = Array(Array('?'))
    val expected = Array(Array('*'))
    Border('*', '*').applyTo(array)
    assertThat(array, is(expected))
  }

  @Test
  def drawABorderForASmallArray() {
    val array = Array(
      Array('?', '?'),
      Array('?', '?')
    )
    val expected = Array(
      Array('*', '*'),
      Array('*', '*')
    )
    Border('*', '*').applyTo(array)
    assertThat(array, is(expected))
  }

  @Test
  def emptyArrayIsUntouched() {
    val array: Array[Array[Char]] = Array(Array())
    val expected: Array[Array[Char]] = Array(Array())
    Border('=', '*').applyTo(array)
    assertThat(array, is(expected))

  }
}
