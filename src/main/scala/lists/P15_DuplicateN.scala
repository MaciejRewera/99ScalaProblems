package lists

object P15_DuplicateN {

  def duplicateN[A](amount: Int, input: List[A]): List[A] =
    input.flatMap(List.fill(amount)(_))

}
