package lists

object P09_Pack {

  def pack[A](input: List[A]): List[List[A]] =
    P13_EncodeDirect.encodeDirect(input).map(t => List.fill(t._1)(t._2))

}
