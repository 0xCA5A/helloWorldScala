object ByNameByValue {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")

    byNameTest(2 < 3)
    byValueTest(() => 2 < 3)

    byNameTest(2 > 3)
    byValueTest(() => 2 > 3)
  }

  // function input parameter: () => Boolean
  def byValueTest(predicate: () => Boolean) = if (!predicate()) throw new AssertionError
  // by name parameter: => Boolean
  def byNameTest(predicate: => Boolean) = if (!predicate) throw new AssertionError
}