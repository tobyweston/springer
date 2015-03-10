package com.springer.drawing

case class NewCanvas(width: Int, height: Int) extends Drawable {
  override def applyTo(canvas: Canvas) = ArrayCanvas(width, height)
}
