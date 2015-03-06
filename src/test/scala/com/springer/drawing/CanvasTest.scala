package com.springer.drawing

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._

class CanvasTest {

  val canvas = Canvas(10, 4)

  @Test
  def displayEmptyCanvas() {
    assertThat(canvas.toString, is(
      """------------
        *|          |
        *|          |
        *|          |
        *|          |
        *------------""".stripMargin('*')))
  }

  @Test
  def canDrawSingleCharacter() {
    canvas.drawCharacter(Coordinate(1, 2), 'x')
    assertThat(canvas.toString, is(
      """------------
        *|          |
        *|x         |
        *|          |
        *|          |
        *------------""".stripMargin('*')))
  }

  @Test
  def drawingCharactersOnBorderRegion() {
    val original = canvas.toString
    canvas.drawCharacter(Coordinate(0, 2), '?')
    assertThat(canvas.toString, is(original))
    canvas.drawCharacter(Coordinate(2, 0), '?')
    assertThat(canvas.toString, is(original))
  }

  @Test
  def drawingCharactersOutsideWidth() {
    val original = canvas.toString
    canvas.drawCharacter(Coordinate(11, 1), '?')
    assertThat(canvas.toString, is(original))
  }

  @Test
  def drawingCharactersOutsideHeight() {
    val original = canvas.toString
    canvas.drawCharacter(Coordinate(1, 5), '?')
    assertThat(canvas.toString, is(original))
  }

}
