import scala.collection.mutable

object Problem_1105B {
  // Salem and Sticks

  def main(args: Array[String]) {
    val scan = scala.io.StdIn

    //Get inputs
    val inputs: Array[Int] = scan.readLine().split(" ").map(_.toInt)
    val targetArr: String = scan.readLine()
    val n = inputs(0)
    val k = inputs(1)
    val occMap = Array.fill(256)(0)

    var x = 0
    while (x < n - k + 1) {
      val tempChar = targetArr(x)
      if (targetArr.substring(x, x + k).count(_ == tempChar) == k) {
        occMap(tempChar) += 1
        x += k
      }
      else{
        while(targetArr(x) == targetArr(x+1)){
          x+=1
        }
        x+=1
      }

    }
    val ans = occMap.max
    println(ans)
  }

}
