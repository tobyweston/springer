package com.springer.drawing

trait Shape {
  def applyTo(canvas: Canvas)
}

class Line(start: Coordinate, end: Coordinate) extends Shape {
  def applyTo(canvas: Canvas): Unit = {
    for (x <- start.x to end.x; y <- start.y to end.y) {
      canvas.drawCharacter(Coordinate(x, y), 'x')
    }
  }
}

object Test extends App {
  val canvas = Canvas(10, 4)
  new Line(Coordinate(1, 2), Coordinate(6, 2)).applyTo(canvas)
  println(canvas.toString)
}


