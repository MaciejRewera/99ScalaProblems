package lists

object P13_EncodeDirect {

  def encodeDirect[A](input: List[A]): List[(Int, A)] =
    input.foldLeft(List.empty[(Int, A)]) { (list, elem) =>
      list match {
        case Nil => List((1, elem))
        case initialTuples :+ lastTuple if lastTuple._2 == elem => initialTuples :+ (lastTuple._1 + 1, elem)
        case _ => list :+ (1, elem)
      }
    }

}
