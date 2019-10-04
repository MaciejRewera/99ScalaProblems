package lists

import scala.annotation.tailrec

object P08_Compress {

  def compress[A](input: List[A]): List[A] = {

    @tailrec
    def comp(revAcc: List[A], rest: List[A]): List[A] = rest match {
      case Nil => revAcc
      case hd :: tl if hd != revAcc.head => comp(hd +: revAcc, tl)
      case _ => comp(revAcc, rest.tail)
    }

    if (input.nonEmpty) comp(List(input.head), input.tail).reverse else Nil
  }

}
