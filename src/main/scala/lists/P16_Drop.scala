package lists

import scala.annotation.tailrec

object P16_Drop {

  def dropTailRec[A](n: Int, input: List[A]): List[A] = {

    @tailrec
    def dropTailRec(dropCounter: Int, acc: List[A], rest: List[A]): List[A] = (dropCounter, rest) match {
      case (_, Nil) => acc
      case (1, _ :: tl) => dropTailRec(n, acc, tl)
      case (_, hd :: tl) => dropTailRec(dropCounter - 1, acc :+ hd, tl)
    }

    if (n < 0)
      throw new IllegalArgumentException("n cannot be negative")
    else
      dropTailRec(n, Nil, input)

  }

  def dropSimpleRec[A](n: Int, input: List[A]): List[A] = {

    def dropSimpleRec(dropCounter: Int, rest: List[A]): List[A] = (dropCounter, rest) match {
      case (_, Nil) => Nil
      case (1, _ :: tl) => dropSimpleRec(n, tl)
      case (_, hd :: tl) => hd :: dropSimpleRec(dropCounter - 1, tl)
    }

    if (n < 0)
      throw new IllegalArgumentException("n cannot be negative")
    else
      dropSimpleRec(n, input)
  }

}
