//object Problem_1105A {
//  // Salem and Sticks
//
//
//  def main(args: Array[String]) {
//    val scan = scala.io.StdIn
//
//    scan.readLine()
//    val targetArr: Array[Int] = scan.readLine().split(" ").map(_.toInt)
//
//    val sorted:Array[Int] = targetArr.sorted
//    val middle = targetArr(targetArr.length/2)
//
//
//    for (t<- middle to sorted.max) {
//
//    }
//
//
//
//
////
////    var t = 0
////    val target = Math.floor(Math.abs(targetArr.min - targetArr.max) / 2.0).toInt
////    if (target < 2) {
////      t = target + targetArr.min
////    }
////    else {
////      t = target - targetArr.min
////    }
//    81   891
////
////    val cost = targetArr.foldLeft(0) {
////      case (acc, x) =>
////        if (Math.abs(t - x) <= 1)
////          acc
////        else
////          acc + Math.abs(x - t) - 1
////    }
////    println(t + " " + cost)
//  }
//
//}
