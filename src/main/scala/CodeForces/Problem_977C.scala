package CodeForces

object Problem_977C {
  // Less or Equal
  // The first line of the input contains integer numbers n and k (1≤n≤2⋅105, 0≤k≤n).
  // The second line of the input contains n integer numbers a1,a2,…,an (1≤ai≤109) — the sequence itself.

  def main(args: Array[String]) {
    val scan = scala.io.StdIn

    //Get inputs
    val inputs: Array[Int] = scan.readLine().split(" ").map(_.toInt)
    val targetArr: Array[Int] = scan.readLine().split(" ").map(_.toInt)
    val n = inputs(0)
    val k = inputs(1)


    val ans = k match {
      case 0 => targetArr.min match {
        case 1 => "-1"
        case _ => targetArr.min - 1
      }
      case _ if k == n => targetArr.max
      case insideK =>
        val sortedArr = targetArr.sorted
        if(sortedArr(insideK - 1) == sortedArr(insideK))
          "-1"
        else
          sortedArr(insideK - 1)
    }

    print(ans)
  }

}
