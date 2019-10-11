package lists

import scala.annotation.tailrec

object P17_Split {

  def split[A](n: Int, input: List[A]): (List[A], List[A]) =
    if (n < 0) throw new IllegalArgumentException("n cannot be negative")
    else {

      @tailrec
      def splitTailRec(counter: Int, first: List[A], second: List[A]): (List[A], List[A]) =
        (counter, second) match {
          case (0, _)        => (first, second)
          case (_, Nil)      => (first, Nil)
          case (_, hd :: tl) => splitTailRec(counter - 1, first :+ hd, tl)
        }

      splitTailRec(n, List.empty, input)
    }

}
