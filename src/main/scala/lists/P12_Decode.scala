package lists

object P12_Decode {

  def decode[A](input: List[(Int, A)]): List[A] = input.flatMap(elem => List.fill(elem._1)(elem._2))

}
