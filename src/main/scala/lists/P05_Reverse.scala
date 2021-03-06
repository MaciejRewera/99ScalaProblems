package lists

object P05_Reverse {

  def reverse[A](input: List[A]): List[A] = input match {
    case Nil => Nil
    case head +: tail => reverse(tail) :+ head
  }

  def reverseWithFold[A](input: List[A]): List[A] =
    input.foldLeft(List.empty[A]) { (list, elem) => elem +: list }

}
