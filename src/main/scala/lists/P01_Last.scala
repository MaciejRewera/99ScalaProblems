package lists

object P01_Last {

  def last[A](input: List[A]): A = input match {
    case Nil => throw new NoSuchElementException
    case _ :+ e => e
  }
}
