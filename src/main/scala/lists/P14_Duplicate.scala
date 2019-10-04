package lists

object P14_Duplicate {

  def duplicate[A](input: List[A]): List[A] = input.flatMap(elem => List(elem, elem))

}
