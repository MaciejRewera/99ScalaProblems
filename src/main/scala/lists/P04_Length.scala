package lists

object P04_Length {

  def length[A](input: List[A]): Int = {
    lengthCounter[A](0, input)
  }

  private def lengthCounter[A](counter: Int, input: List[A]): Int = input match {
    case Nil => counter
    case _ => lengthCounter[A](counter + 1, input.tail)
  }

}
