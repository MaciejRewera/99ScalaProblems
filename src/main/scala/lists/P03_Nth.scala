package lists

import scala.annotation.tailrec

object P03_Nth {

  def nth[A](n: Int, input: List[A]): A = {
    if ((n >= input.size) || (n < 0)) throw new IndexOutOfBoundsException
    else iterate[A](n, input)
  }

  @tailrec
  private def iterate[A](n: Int, input: List[A]): A = n match {
    case 0 => input head
    case _ => iterate[A](n - 1, input.tail)
  }

}
