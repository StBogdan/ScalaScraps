
object Problem_1111A {

  def main(args: Array[String]) {
    val scan = scala.io.StdIn
    val s1: String = scan.readLine()
    val s2: String = scan.readLine()

    if(s1.length != s2.length){
      print("No")
      return
    }

    var areSame= true;
    for (i <- 0 until s1.length) {
      if(isVowel(s1(i)) != isVowel(s2(i))){
        areSame =false
      }
    }

    if(areSame){
      print("Yes")
    }
    else{
      print("No")
    }

  }

  def isVowel(x : Char) ={
    val vowels: Array[Char] = Array('a','e','i','o','u')
    vowels.contains(x)
  }


}
