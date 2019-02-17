import scala.collection.mutable

object Problem_1111B {

  def main(args: Array[String]) {
    val scan = scala.io.StdIn
    val inputs: Array[Int] = scan.readLine().split(" ").map(_.toInt)
    var sups: mutable.Buffer[Int] = scan.readLine().split(" ").map(_.toInt).sorted.reverse.toBuffer

    val n = inputs(0)
    val k = inputs(1)
    val m = inputs(2)

    var sumArr: Array[Int] = Array.fill(n+1){0}

    for (i <- 1 to n)
      sumArr(i) = sumArr(i-1) + sups(i-1)
    sumArr = sumArr.reverse
    var cmax:Double = (sumArr(0) + (m min (n*k) )).toDouble / n
    var goOn= true
    for (i <- 1 until n if goOn){
      if( i > m )  //Can still make moves
        goOn = false
        val temp: Double = (sumArr(i) + ((n-i)*k min m-i) ).toDouble / (n-i)
        cmax = temp max cmax
      }
    print(f"${cmax}%1.10f")
  }

}
