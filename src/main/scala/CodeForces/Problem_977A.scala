package CodeForces

object Problem_977A {
//  Wrong_Substraction

  def wrongSub(x: Int, subs_left: Int): Int = {
    if (subs_left == 0)
      x
    else if (x % 10 == 0)
      wrongSub(x / 10, subs_left - 1)
    else
      wrongSub(x - 1, subs_left - 1)
  }

  def main(args: Array[String]) {
    val scan = scala.io.StdIn
    val inputs: Array[Int] = scan.readLine.split(" ").map(_.toInt)

    println(wrongSub(inputs(0), inputs(1)))
  }

}
