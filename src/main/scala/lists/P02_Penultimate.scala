package lists

object P02_Penultimate {

  def penultimate[A](input: List[A]): A = input match {
    case Nil => throw new NoSuchElementException
    case _ +: Nil => throw new NoSuchElementException
    case _ :+ e :+ _ => e
  }

}
