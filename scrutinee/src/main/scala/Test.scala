package test

object Test {
  def quicksort(xs: Array[Int]) = {
    def swap(i: Int, j: Int) {
      val t = xs(i)
      xs(i) = xs(j)
      xs(j) = t
    }

    def sort1(l: Int, r: Int): Unit = {
      val pivot = xs((l + r) / 2)
      var i = l
      var j = r
      while (i <= j) {
        while (xs(i) < pivot) i = i + 1
        while (xs(j) > pivot) j = j - 1

        if (i <= j) {
          swap(i, j)
          i = i + 1
          j = j - 1
        }
      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)
    }

    sort1(0, xs.length - 1)
  }
}
