package CodeForces

object Problem_977B {
  //  Two-gram

  def main(args: Array[String]) {
    val scan = scala.io.StdIn
    val len: Int = scan.readLine.toInt
    val targetStr: String = scan.readLine()

    val occurenceMap = targetStr.foldLeft(Map.empty[String, Int], ' ') {
      case ((map: Map[String, Int], prevChar: Char), elem: Char) =>
        if (prevChar != ' ') {
          (map + (f"$prevChar$elem" -> (map.getOrElse(s"$prevChar$elem", 0) + 1)), elem)
        }
        else {
          (map, elem)
        }
    }._1

    println(occurenceMap.maxBy(_._2)._1)
  }

}
