package com.springer.drawing

object DrawNothing {
  def apply() = new DrawNothing
}

class DrawNothing extends Drawable {
  override def applyTo(canvas: Canvas) = canvas
}
