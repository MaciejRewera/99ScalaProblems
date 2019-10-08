package lists

object P16_Drop {

  def drop[A](n: Int, input: List[A]): List[A] = {

    def dropRec(dropCounter: Int, acc: List[A], rest: List[A]): List[A] = rest match {
      case Nil => acc
      case hd :: tl => dropCounter match {
        case 1 => dropRec(n, acc, tl)
        case _ => dropRec(dropCounter - 1, acc :+ hd, tl)
      }
    }

    if (n < 0)
      throw new IllegalArgumentException("n cannot be negative")
    else
      dropRec(n, Nil, input)
  }

}
