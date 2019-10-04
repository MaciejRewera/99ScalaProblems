package lists

object P07_Flatten {

  def flatten(input: List[_]): List[_] = input match {
    case Nil => Nil
    case (list: List[_]) :: tail => flatten(list) ::: flatten(tail)
    case elem +: tail => elem +: flatten(tail)
  }

}
