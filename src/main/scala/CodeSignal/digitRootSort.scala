package CodeSignal

object digitRootSort extends App {

  try {
    assert(digitRootSort(Array(13, 20, 7, 4)) == Array(20, 4, 13, 7))
    assert(digitRootSort(Array(100, 22, 4, 11, 31, 103)) == Array(100, 11, 4, 22, 31, 103))
    println("Provided test cases succeed")
  }
  catch {
    case e:AssertionError => e.printStackTrace()
  }


  /**
    * Digit root of some positive integer is defined as the sum of all of its digits.
    * You are given an array of integers.
    * Sort it in such a way that if a comes before b then the digit root of a is less than or equal to the digit root of b.
    * If two numbers have the same digit root, the smaller one (in the regular sense) should come first.
    * For example 4 and 13 have the same digit root, however 4 < 13 thus 4 comes before 13 in any digitRoot sorting where both are present.
    */
  def digitRootSort(a: Array[Int]): Array[Int] = {
    a.sortWith{ (x,y) =>
        val xRoot = getNumberRoot(x)
        val yRoot= getNumberRoot(y)
      if(xRoot==yRoot)
        x<y
      else
        xRoot<yRoot
    }
  }

  def getNumberRoot(x:Int) = x.toString.foldLeft(0){
    case (acc,x) => acc+x.asDigit
  }

}
